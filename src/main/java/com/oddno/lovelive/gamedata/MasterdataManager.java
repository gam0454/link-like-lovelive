package com.oddno.lovelive.gamedata;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MasterdataManager {

	private static final DateTimeFormatter DATE_FORMATTER = new DateTimeFormatterBuilder()
			.appendPattern("yyyy-MM-dd HH:mm:ss")
			.parseDefaulting(ChronoField.OFFSET_SECONDS, 0)
			.toFormatter();

	public static long readVarint64(InputStream stream) throws IOException {
		long value = 0;
		int shift = 0;
		for (int byteCount = 0; byteCount < 10; byteCount++) {
			int currentByte = stream.read();
			if (currentByte == -1) {
				throw new EOFException("Stream ended prematurely while decoding varint.");
			}
			if ((currentByte & 0x80) == 0) {
				return value | ((long) currentByte << shift);
			}
			value |= ((long) (currentByte & 0x7F) << shift);
			shift += 7;
		}
		throw new IOException("Variable length integer is too large.");
	}

	public static <T> List<T> load(String dataLabel, Class<T> targetClass) {
		File sourceFile = new File("./masterdata/", dataLabel);

		try (DataInputStream reader = new DataInputStream(new BufferedInputStream(new FileInputStream(sourceFile)))) {

			short header = reader.readShort();
			if (header != (short) 0xDA00) {
				throw new IllegalStateException("Invalid file format signature for: " + dataLabel);
			}

			reader.skipBytes(2);

			long totalRows = readVarint64(reader);
			long totalColumns = readVarint64(reader);

			if (totalRows <= 0) {
				return new ArrayList<>();
			}

			int[] columnTypes = new int[(int) totalColumns];
			for (int c = 0; c < totalColumns; c++) {
				reader.readInt(); // UpdateTableFromBinary
				columnTypes[c] = reader.readInt();
			}

			List<T> recordList = new ArrayList<>((int) totalRows);
			Constructor<T> beanConstructor = targetClass.getDeclaredConstructor();
			beanConstructor.setAccessible(true);
			for (int r = 0; r < totalRows; r++) {
				recordList.add(beanConstructor.newInstance());
			}

			Field[] classFields = targetClass.getDeclaredFields();
			for (int colIdx = 0; colIdx < totalColumns; colIdx++) {
				if (colIdx >= classFields.length) {
					break;
				}

				Field targetField = classFields[colIdx];
				targetField.setAccessible(true);
				DataType typeDefinition = DataType.ofCode(columnTypes[colIdx]);

				for (int rowIdx = 0; rowIdx < totalRows; rowIdx++) {
					setFieldValue(recordList.get(rowIdx), reader, targetField, typeDefinition);
				}
			}

			System.out.printf("[%s] Successfully loaded %d rows.\n", dataLabel, totalRows);
			return recordList;

		} catch (Exception failure) {
			System.err.println("CRITICAL: Failed to process master data file -> " + dataLabel);
			failure.printStackTrace();
			return null;
		}
	}

	private enum DataType {
		STRING(16),
		VARINT(32),
		INT8(48),
		INT16(49),
		INT32(50),
		INT64(51);

		private final int typeCode;

		DataType(int typeCode) {
			this.typeCode = typeCode;
		}

		public static DataType ofCode(int code) {
			for (DataType type : values()) {
				if (type.typeCode == code)
					return type;
			}
			throw new UnsupportedOperationException("Unknown binary data type code: " + code);
		}
	}

	private static void setFieldValue(Object targetObj, DataInputStream reader, Field field, DataType dataType)
			throws Exception {
		switch (dataType) {
			case STRING:
				String textValue = readNullTerminatedString(reader);
				assignStringPayload(targetObj, field, textValue);
				break;

			case VARINT:
				long dynamicLong = readVarint64(reader);
				assignNumericPayload(targetObj, field, dynamicLong);
				break;

			case INT8:
				assignNumericPayload(targetObj, field, reader.readByte());
				break;

			case INT16:
				assignNumericPayload(targetObj, field, reader.readShort());
				break;

			case INT32:
				assignNumericPayload(targetObj, field, reader.readInt());
				break;

			case INT64:
				assignNumericPayload(targetObj, field, reader.readLong());
				break;
		}
	}

	private static String readNullTerminatedString(InputStream in) throws IOException {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		int character;
		while ((character = in.read()) != 0x00 && character != -1) {
			buffer.write(character);
		}
		return buffer.toString("UTF-8");
	}

	private static void assignNumericPayload(Object targetObj, Field field, long value) throws IllegalAccessException {
		Class<?> fieldType = field.getType();
		if (fieldType == int.class || fieldType == Integer.class) {
			field.set(targetObj, (int) value);
		} else if (fieldType == long.class || fieldType == Long.class) {
			field.set(targetObj, value);
		} else if (fieldType == short.class || fieldType == Short.class) {
			field.set(targetObj, (short) value);
		} else if (fieldType == byte.class || fieldType == Byte.class) {
			field.set(targetObj, (byte) value);
		} else {
			field.set(targetObj, value);
		}
	}

	private static void assignStringPayload(Object targetObj, Field field, String rawText)
			throws IllegalAccessException {
		Class<?> fieldType = field.getType();
		if (fieldType == String.class) {
			field.set(targetObj, rawText);
		} else if (fieldType == OffsetDateTime.class) {
			field.set(targetObj, OffsetDateTime.parse(rawText, DATE_FORMATTER));
		} else if (fieldType == List.class) {
			Type genericType = field.getGenericType();
			if (genericType instanceof ParameterizedType) {
				Type templateType = ((ParameterizedType) genericType).getActualTypeArguments()[0];
				if (templateType == Integer.class) {
					if (rawText.isEmpty()) {
						field.set(targetObj, Collections.emptyList());
					} else {
						String[] tokens = rawText.split(",");
						List<Integer> parsedNumbers = new ArrayList<>(tokens.length);
						for (String token : tokens) {
							parsedNumbers.add(Integer.parseInt(token.trim()));
						}
						field.set(targetObj, parsedNumbers);
					}
				}
			}
		}
	}
}
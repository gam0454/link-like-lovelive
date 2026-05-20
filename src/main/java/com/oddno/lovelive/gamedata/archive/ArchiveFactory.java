package com.oddno.lovelive.gamedata.archive;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.oddno.lovelive.dto.response.archive.FilterableCharacter;
import com.oddno.lovelive.dto.response.archive.SortableField;
import com.oddno.lovelive.enums.LiveTicketRank;
import com.oddno.lovelive.enums.LiveType;
import com.oddno.lovelive.gamedata.ServerdataReader;
import com.oddno.lovelive.util.DateUtils;

public class ArchiveFactory {

	private static Map<String, Archive> archives = new LinkedHashMap<>();
	private static List<Archive> cachedList = new ArrayList<>();
	private static List<FilterableCharacter> filters = new ArrayList<>();
	private static List<SortableField> fields = new ArrayList<>();

	public static void loadData() {
		Connection con = ServerdataReader.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("SELECT * FROM archives");
			rs = ps.executeQuery();
			while (rs.next()) {
				String archivesId = rs.getString("archives_id");
				LiveType liveType = LiveType.fromInt(rs.getInt("live_type"));
				String liveId = rs.getString("live_id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				int liveLocationId = rs.getInt("live_location_id");
				String externalLink = rs.getString("external_link");
				String thumbnailImageUrl = rs.getString("thumbnail_image_url");
				LiveTicketRank ticketRank = LiveTicketRank.fromInt(rs.getInt("ticket_rank"));
				int totalPlayingTimeSecond = rs.getInt("total_playing_time_second");
				String videoUrl = rs.getString("video_url");
				long archiveVideoSizeInByte = rs.getLong("archive_video_size_in_byte");

				boolean isPublishVideoUrl = rs.getInt("is_publish_video_url") == 1;
				boolean isExtraStarted = rs.getInt("is_extra_started") == 1;
				boolean hasExtra = rs.getInt("has_extra") == 1;
				boolean hasExtraAdmission = rs.getInt("has_extra_admission") == 1;
				boolean isScheduledStartTimeVisible = rs.getInt("is_scheduled_start_time_visible") == 1;

				int earnedStarCount = rs.getInt("earned_star_count");
				int giftStarsThreshold = rs.getInt("gift_stars_threshold_for_extra_admission");

				LocalDateTime trailerStartTime = DateUtils.convertUnixToLocal(rs.getLong("trailer_start_time"));
				LocalDateTime trailerEndTime = DateUtils.convertUnixToLocal(rs.getLong("trailer_end_time"));
				LocalDateTime liveStartTime = DateUtils.convertUnixToLocal(rs.getLong("live_start_time"));
				LocalDateTime liveEndTime = DateUtils.convertUnixToLocal(rs.getLong("live_end_time"));
				LocalDateTime startTime = DateUtils.convertUnixToLocal(rs.getLong("start_time"));
				LocalDateTime endTime = DateUtils.convertUnixToLocal(rs.getLong("end_time"));
				LocalDateTime openTime = DateUtils.convertUnixToLocal(rs.getLong("open_time"));
				LocalDateTime closeTime = DateUtils.convertUnixToLocal(rs.getLong("close_time"));

				Archive archive = Archive.builder()
						.archivesId(archivesId)
						.liveType(liveType)
						.liveId(liveId)
						.name(name)
						.description(description)
						.liveLocationId(liveLocationId)
						.ticketList(new ArrayList<>())
						.trailerStartTime(trailerStartTime)
						.trailerEndTime(trailerEndTime)
						.liveStartTime(liveStartTime)
						.liveEndTime(liveEndTime)
						.startTime(startTime)
						.endTime(endTime)
						.openTime(openTime)
						.closeTime(closeTime)
						.externalLink(externalLink)
						.thumbnailImageUrl(thumbnailImageUrl)
						.ticketRank(ticketRank)
						.totalPlayingTimeSecond(totalPlayingTimeSecond)
						.isPublishVideoUrl(isPublishVideoUrl)
						.isExtraStarted(isExtraStarted)
						.hasExtra(hasExtra)
						.hasExtraAdmission(hasExtraAdmission)
						.earnedStarCount(earnedStarCount)
						.giftStarsThresholdForExtraAdmission(giftStarsThreshold)
						.videoUrl(videoUrl)
						.archiveVideoSizeInByte(archiveVideoSizeInByte)
						.isScheduledStartTimeVisible(isScheduledStartTimeVisible)
						.build();

				archives.put(archivesId, archive);
				cachedList.add(archive);
			}

			rs.close();
			ps.close();
			System.out.println("archives Loading Completed.");

			ps = con.prepareStatement("SELECT * FROM archive_characters");
			rs = ps.executeQuery();
			while (rs.next()) {
				String archivesId = rs.getString("archives_id");
				int characterId = rs.getInt("character_id");
				boolean isGuest = rs.getBoolean("is_guest");

				ArchiveCharacter character = ArchiveCharacter.builder()
						.characterId(characterId)
						.isGuest(isGuest)
						.build();

				archives.get(archivesId).getCharacterList().add(character);
			}

			rs.close();
			ps.close();
			System.out.println("archive_characters Loading Completed.");

			ps = con.prepareStatement("SELECT * FROM archive_fes_live_chapters");
			rs = ps.executeQuery();
			while (rs.next()) {
				String archivesId = rs.getString("archives_id");
				String name = rs.getString("name");
				int playTimeSecond = rs.getInt("play_time_second");
				boolean isExtra = rs.getBoolean("is_extra");
				boolean isAvailable = rs.getBoolean("is_available");

				ArchiveChapter chapter = ArchiveChapter.builder()
						.name(name)
						.playTimeSecond(playTimeSecond)
						.isExtra(isExtra)
						.isAvailable(isAvailable)
						.build();

				archives.get(archivesId).getChapters().add(chapter);
			}

			rs.close();
			ps.close();
			System.out.println("archive_fes_live_chapters Loading Completed.");

			ps = con.prepareStatement("SELECT * FROM archive_fes_live_costumes");
			rs = ps.executeQuery();
			while (rs.next()) {
				String archivesId = rs.getString("archives_id");
				int costumeId = rs.getInt("costume_id");

				archives.get(archivesId).getCostumes().add(costumeId);
			}

			rs.close();
			ps.close();
			System.out.println("archive_fes_live_costumes Loading Completed.");

			ps = con.prepareStatement("SELECT * FROM archive_fes_live_timelines");
			rs = ps.executeQuery();
			while (rs.next()) {
				String archivesId = rs.getString("archives_id");
				long timelineId = rs.getLong("timeline_id");

				archives.get(archivesId).getTimelines().add(timelineId);
			}

			rs.close();
			ps.close();
			System.out.println("archive_fes_live_timelines Loading Completed.");

			ps = con.prepareStatement("SELECT * FROM archive_filterable_characters");
			rs = ps.executeQuery();
			while (rs.next()) {
				int characterId = rs.getInt("character_id");
				String label = rs.getString("label");

				FilterableCharacter filter = FilterableCharacter.builder()
						.characterId(characterId)
						.label(label)
						.build();

				filters.add(filter);
			}

			rs.close();
			ps.close();
			System.out.println("archive_filterable_characters Loading Completed.");

			ps = con.prepareStatement("SELECT * FROM archive_sortable_fields");
			rs = ps.executeQuery();
			while (rs.next()) {
				String key = rs.getString("key");
				String label = rs.getString("label");

				SortableField sortableField = SortableField.builder().key(key).label(label).build();

				fields.add(sortableField);
			}

			rs.close();
			ps.close();
			System.out.println("archive_sortable_fields Loading Completed.");

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (rs != null) {
					rs.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ignore) {
			}
		}
	}

	public static List<Archive> getArchiveList() {
		return cachedList;
	}

	public static Map<String, Archive> getArchives() {
		return archives;
	}

	public static Archive getArchive(String archivesId) {
		return archives.get(archivesId);
	}

	public static List<FilterableCharacter> getFilters() {
		return filters;
	}

	public static List<SortableField> getSortableFields() {
		return fields;
	}
}

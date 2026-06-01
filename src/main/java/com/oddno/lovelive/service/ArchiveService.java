package com.oddno.lovelive.service;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.oddno.lovelive.dto.request.GetArchiveListRequest;
import com.oddno.lovelive.dto.request.GetArchiveListRequest.OrderEnum;
import com.oddno.lovelive.dto.request.GetFesArchiveDataRequest;
import com.oddno.lovelive.dto.request.GetWithArchiveDataRequest;
import com.oddno.lovelive.dto.request.SetFesCameraRequest;
import com.oddno.lovelive.dto.request.archive.GetArchiveListRequestCharactersInner;
import com.oddno.lovelive.dto.response.ArchiveWithliveInfoResponse;
import com.oddno.lovelive.dto.response.GetArchiveListResponse;
import com.oddno.lovelive.dto.response.GetFesArchiveDataResponse;
import com.oddno.lovelive.dto.response.GetFesTimelineDataResponse;
import com.oddno.lovelive.dto.response.GetHomeResponse;
import com.oddno.lovelive.dto.response.GetWithArchiveDataResponse;
import com.oddno.lovelive.dto.response.SetFesCameraResponse;
import com.oddno.lovelive.dto.response.archive.ArchiveFesliveChapter;
import com.oddno.lovelive.dto.response.archive.LiveArchiveCharacter;
import com.oddno.lovelive.dto.response.archive.LiveInfo;
import com.oddno.lovelive.enums.FilterCharacterAppearance;
import com.oddno.lovelive.enums.FilterHasWithliveExtra;
import com.oddno.lovelive.enums.FilterHasWithliveExtraAdmission;
import com.oddno.lovelive.enums.LiveCameraType;
import com.oddno.lovelive.enums.LiveTicketRank;
import com.oddno.lovelive.gamedata.archive.Archive;
import com.oddno.lovelive.gamedata.archive.ArchiveFactory;
import com.oddno.lovelive.util.DateUtils;

@Service
public class ArchiveService {

	public GetHomeResponse getHome() {
		return GetHomeResponse.builder()
				.favoriteChannelList(new ArrayList<>())
				.liveArchiveList(new ArrayList<>())
				.trailerArchiveList(new ArrayList<>())
				.recommendArchiveList(new ArrayList<>())
				.withStationList(new ArrayList<>())
				.musicVideoList(new ArrayList<>())
				.build();
	}

	public GetArchiveListResponse getArchiveList(GetArchiveListRequest request) {
		Stream<Archive> stream = ArchiveFactory.getArchiveList().stream();

		if (request.getLiveType() != null) {
			stream = stream.filter(i -> i.getLiveType().getValue() == request.getLiveType().getValue());
		}

		if (request.getHasWithliveExtra() != null) {
			boolean target = (request.getHasWithliveExtra() == FilterHasWithliveExtra.FILTER_HAS_WITHLIVE_EXTRA_TRUE);
			stream = stream.filter(i -> i.isHasExtra() == target);
		}

		if (request.getHasWithliveExtraAdmission() != null) {
			boolean target = (request
					.getHasWithliveExtraAdmission() == FilterHasWithliveExtraAdmission.FILTER_HAS_WITHLIVE_EXTRA_ADMISSION_TRUE);
			stream = stream.filter(i -> i.isHasExtraAdmission() == target);
		}

		if (request.getCharacters() != null) {
			stream = stream.filter(archive -> {
				for (GetArchiveListRequestCharactersInner req : request.getCharacters()) {
					boolean isPresent = archive.getCharacterList()
							.stream()
							.anyMatch(c -> c.getCharacterId() == req.getCharacterId());

					if (req.getAppearance() == FilterCharacterAppearance.FILTER_CHARACTER_APPEARANCE_TRUE && !isPresent)
						return false;
					if (req.getAppearance() == FilterCharacterAppearance.FILTER_CHARACTER_APPEARANCE_FALSE && isPresent)
						return false;
				}
				return true;
			});
		}
		List<Archive> result = stream.collect(Collectors.toList());

		if (request.getOrder() != null) {
			Comparator<Archive> comparator;

			if ("star_count".equals(request.getSort())) {
				comparator = Comparator.comparing(Archive::getEarnedStarCount);
			} else {
				comparator = Comparator.comparing(Archive::getLiveStartTime);
			}

			if (request.getOrder() == OrderEnum.DESC) {
				result.sort(comparator.reversed());
			} else {
				result.sort(comparator);
			}
		}

		int totalSize = result.size();
		int fromIndex = Math.min(request.getOffset(), totalSize);
		int toIndex = Math.min(fromIndex + request.getLimit(), totalSize);

		List<LiveInfo> pagedList = result.subList(fromIndex, toIndex)
				.stream()
				.map(archive -> LiveInfo.fromDto(archive))
				.toList();

		return GetArchiveListResponse.builder()
				.archiveList(new ArrayList<>(pagedList))
				.filterableCharacters(ArchiveFactory.getFilters())
				.sortableFields(ArchiveFactory.getSortableFields())
				.build();
	}

	public GetWithArchiveDataResponse getWithArchiveData(GetWithArchiveDataRequest request) {
		Archive archive = ArchiveFactory.getArchive(request.getArchivesId());
		return GetWithArchiveDataResponse.builder()
				.timelines(new ArrayList<>())
				.giftPtRankings(new ArrayList<>())
				.liveLocationId(archive.getLiveLocationId())
				.costumeIds(new ArrayList<>())
				.timelineIds(new ArrayList<>())
				.archiveUrl(archive.getVideoUrl())
				.videoUrl(archive.getVideoUrl())
				.chapters(new ArrayList<>())
				.hasExtra(true)
				.giftStarRewardSegments(List.of(10000, 30000, 60000, 100000))
				.giftStarsThresholdForExtraAdmission(1)
				.hasExtraAdmission(false)
				.currentPlayTimeSecond(0)
				.totalPlayTimeSecondWithoutExtra(0)
				.totalPlayTimeSecondIncludingExtra(0)
				.unixtimeLiveRecStarted(archive.getLiveStartTime().toEpochSecond(ZoneOffset.UTC))
				.liveStartTime(DateUtils.formatToUtcString(archive.getLiveStartTime()))
				.title(archive.getName())
				.description(archive.getDescription())
				.contentCode(999)
				.viewerCount(0)
				.userIconPartsInfo("")
				.userGiftPtWithoutArchive(0)
				.userGiftPtIncludingArchive(0)
				.userGiftPtRanking(0)
				.totalGiftPt(null)
				.characters(new ArrayList<>())
				.isArchivePublished(true)
				.enquetes(new ArrayList<>())
				.build();
	}

	public ArchiveWithliveInfoResponse withliveInfo() {
		return ArchiveWithliveInfoResponse.builder()
				.timelines(new ArrayList<>())
				.pollingInterval(1)
				.hasExtraAdmission(false)
				.isArchivePublished(true)
				.build();
	}

	public GetFesArchiveDataResponse getFesArchiveData(GetFesArchiveDataRequest request) {
		Archive archive = ArchiveFactory.getArchive(request.getArchivesId());
		return GetFesArchiveDataResponse.builder()
				.timelines(new ArrayList<>())
				.giftPtRankings(new ArrayList<>())
				.liveLocationId(archive.getLiveLocationId())
				.costumeIds(archive.getCostumes())
				.liveTimelineIds(new ArrayList<>())
				.timelineIds(new ArrayList<>())
				//				.timelineIds(archive.getTimelines())
				.archiveUrl(archive.getExternalLink())
				.videoUrl(archive.getVideoUrl())
				.chapters(ArchiveFesliveChapter.fromDtos(archive.getChapters()))
				.hasExtraAdmission(archive.isHasExtraAdmission())
				.currentPlayTimeSecond(0)
				.totalPlayTimeSecond(archive.getTotalPlayingTimeSecond())
				.unixtimeLiveRecStarted(archive.getLiveStartTime().toEpochSecond(ZoneOffset.UTC))
				.liveStartTime(DateUtils.formatToUtcString(archive.getLiveStartTime()))
				.title(archive.getName())
				.description(archive.getDescription())
				.contentCode(999)
				.viewerCount(0)
				.userIconPartsInfo("")
				.userGiftPt(0)
				.userGiftPtRanking(0)
				.totalGiftPt(null)
				.characterIds(new ArrayList<>())
				.characters(LiveArchiveCharacter.fromDtos(archive.getCharacterList()))
				.enquetes(new ArrayList<>())
				.selectableCameraTypes(List.of(LiveCameraType.LIVE_CAMERA_TYPE_DYNAMIC_VIEW,
						LiveCameraType.LIVE_CAMERA_TYPE_ARENA_VIEW, LiveCameraType.LIVE_CAMERA_TYPE_STAND_VIEW,
						LiveCameraType.LIVE_CAMERA_TYPE_SCHOOL_IDLE))
				.currentCameraType(LiveCameraType.LIVE_CAMERA_TYPE_DYNAMIC_VIEW)
				.ticketRank(LiveTicketRank.TICKET_RANK_S)
				.build();
	}

	public GetFesTimelineDataResponse getFesTimelineData() {
		return GetFesTimelineDataResponse.builder().timelines(new ArrayList<>()).pollingInterval(1).build();
	}

	public SetFesCameraResponse setFesCamera(SetFesCameraRequest request) {
		return SetFesCameraResponse.builder().cameraType(request.getCameraType()).focusCharacterId(0).build();
	}
}

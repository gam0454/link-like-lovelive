package com.oddno.lovelive.gamedata.archive;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.oddno.lovelive.dto.response.archive.TicketInfo;
import com.oddno.lovelive.enums.LiveTicketRank;
import com.oddno.lovelive.enums.LiveType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Archive {

	private final List<ArchiveChapter> chapters = new ArrayList<>();
	private final List<Integer> costumes = new ArrayList<>();
	private final List<ArchiveCharacter> characterList = new ArrayList<>();
	private final List<Long> timelines = new ArrayList<>();

	private String archivesId;

	private LiveType liveType;

	private String liveId;

	private String name;

	private String description;
	
	private int liveLocationId;

	private List<TicketInfo> ticketList;

	private LocalDateTime trailerStartTime;

	private LocalDateTime trailerEndTime;

	private LocalDateTime liveStartTime;

	private LocalDateTime liveEndTime;

	private LocalDateTime startTime;

	private LocalDateTime endTime;

	private LocalDateTime openTime;

	private LocalDateTime closeTime;

	private String externalLink;

	private String thumbnailImageUrl;

	private LiveTicketRank ticketRank;

	private int totalPlayingTimeSecond;

	private boolean isPublishVideoUrl;

	private boolean isExtraStarted;

	private boolean hasExtra;

	private boolean hasExtraAdmission;

	private int earnedStarCount;

	private int giftStarsThresholdForExtraAdmission;

	private String videoUrl;

	private long archiveVideoSizeInByte;

	private boolean isScheduledStartTimeVisible;
}

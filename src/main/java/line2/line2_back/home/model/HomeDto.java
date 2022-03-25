package line2.line2_back.home.model;

import line2.line2_back.room.model.Room;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@Builder
public class HomeDto {
    private Long homeId;
    private String homeName;
    private String homeAddress;
    private double coordinateX;
    private double coordinateY;
    private Long homeCategoryId;
    private String homeInformation;
    private Long userId;
    private String homeZipCode;
    private List<String> images;
    private List<Long> homePolicies;
    private String homePolicyCustom;
    private List<Long> homeFacilities;
    private List<Room> rooms;
}

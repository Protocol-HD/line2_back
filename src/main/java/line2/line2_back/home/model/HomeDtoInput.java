package line2.line2_back.home.model;

import line2.line2_back.room.model.Room;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class HomeDtoInput {
    private Long homeId;
    private String homeName;
    private String homeAddress;
    private double coordinateX;
    private double coordinateY;
    private Long homeCategoryId;
    private String homeInfomation;
    private String homeHost;
    private String homeHostPhone;
    private String homeHostEmail;
    private String homeZipCode;
    private List<String> images;
    private List<String> homePolicies;
    private List<Long> homeFacilities;
    private List<Room> rooms;
}

package line2.line2_back.home.service;

import line2.line2_back.home.model.Home;
import line2.line2_back.home.model.HomeDtoInput;
import line2.line2_back.home.repository.HomeRepository;
import line2.line2_back.homeCategory.repository.HomeCategoryRepository;
import line2.line2_back.homeFacility.repository.HomeFacilityRepository;
import line2.line2_back.homeFacilityTable.model.HomeFacilityTable;
import line2.line2_back.homeFacilityTable.repository.HomeFacilityTableRepository;
import line2.line2_back.homeImageTable.model.HomeImageTable;
import line2.line2_back.homeImageTable.repository.HomeImageTableRepository;
import line2.line2_back.homePolicy.model.HomePolicy;
import line2.line2_back.homePolicy.repository.HomePolicyRepository;
import line2.line2_back.homePolicyTable.model.HomePolicyTable;
import line2.line2_back.homePolicyTable.repository.HomePolicyTableRepository;
import line2.line2_back.homeRoomTable.model.HomeRoomTable;
import line2.line2_back.homeRoomTable.repository.HomeRoomTableRepository;
import line2.line2_back.image.model.Image;
import line2.line2_back.image.repository.ImageRepository;
import line2.line2_back.room.model.Room;
import line2.line2_back.room.repository.RoomRepository;
import line2.line2_back.systemMessage.SystemMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService {
    private final HomeRepository homeRepository;
    private final HomeCategoryRepository homeCategoryRepository;
    private final ImageRepository imageRepository;
    private final HomeImageTableRepository homeImageTableRepository;
    private final HomePolicyRepository homePolicyRepository;
    private final HomePolicyTableRepository homePolicyTableRepository;
    private final HomeFacilityRepository homeFacilityRepository;
    private final HomeFacilityTableRepository homeFacilityTableRepository;
    private final RoomRepository roomRepository;
    private final HomeRoomTableRepository homeRoomTableRepository;

    public void HomeImageAdd(List<String> images, Home home) {
        images.forEach(image -> {
            homeImageTableRepository.save(
                    HomeImageTable.builder()
                            .home(home)
                            .image(imageRepository.save(Image.builder().imageName(image).build()))
                            .build()
            );
        });
    }

    public void HomePolicyAdd(List<String> homePolicies, Home home) {
        homePolicies.forEach(homePolicy -> {
            homePolicyTableRepository.save(
                    HomePolicyTable.builder()
                            .home(home)
                            .homePolicy(homePolicyRepository.save(HomePolicy.builder().homePolicy(homePolicy).build()))
                            .build()
            );
        });
    }

    public void HomeFacilityAdd(List<Long> homeFacilities, Home home) {
        homeFacilities.forEach(homeFacility -> {
            homeFacilityTableRepository.save(
                    HomeFacilityTable.builder()
                            .home(home)
                            .homeFacility(homeFacilityRepository.findById(homeFacility).get())
                            .build()
            );
        });
    }

    public void HomeRoomAdd(List<Room> rooms, Home home) {
        rooms.forEach(room -> {
            homeRoomTableRepository.save(
                    HomeRoomTable.builder()
                            .home(home)
                            .room(roomRepository.save(
                                    Room.builder()
                                            .roomName(room.getRoomName())
                                            .singleBed(room.getSingleBed())
                                            .doubleBed(room.getDoubleBed())
                                            .bedding(room.getBedding())
                                            .gender(room.getGender())
                                            .maxHeadCount(room.getMaxHeadCount())
                                            .build())
                            )
                            .build()
            );
        });
    }

    @Override
    public SystemMessage save(HomeDtoInput homeDtoInput) {
        try {
            log.info("HomeService save Home({}) start", homeDtoInput);
            Home home = new Home();
            log.info("1. save home");
            home = homeRepository.save(Home.builder()
                    .id(homeDtoInput.getHomeId())
                    .homeName(homeDtoInput.getHomeName())
                    .homeAddress(homeDtoInput.getHomeAddress())
                    .coordinateX(homeDtoInput.getCoordinateX())
                    .coordinateY(homeDtoInput.getCoordinateY())
                    .homeCategory(homeCategoryRepository.findById(homeDtoInput.getHomeCategoryId()).get())
                    .homeInfomation(homeDtoInput.getHomeInfomation())
                    .homeHost(homeDtoInput.getHomeHost())
                    .homeHostPhone(homeDtoInput.getHomeHostPhone())
                    .homeHostEmail(homeDtoInput.getHomeHostEmail())
                    .homeZipCode(homeDtoInput.getHomeZipCode())
                    .build());

            log.info("2. save home images");
            HomeImageAdd(homeDtoInput.getImages(), home);
            log.info("3. save home policies");
            HomePolicyAdd(homeDtoInput.getHomePolicies(), home);
            log.info("4. save home facilities");
            HomeFacilityAdd(homeDtoInput.getHomeFacilities(), home);
            log.info("5. save home rooms");
            HomeRoomAdd(homeDtoInput.getRooms(), home);
            return SystemMessage.builder()
                    .code(1)
                    .message("숙소 등록 성공")
                    .build();
        } catch (Exception e) {
            log.error("HomeService save Home failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("숙소 등록 실패")
                    .build();
        } finally {
            log.info("HomeService save Home end");
        }
    }

    @Override
    public Home findById(Long id) {
        try {
            log.info("HomeService find by id Home(id: {}) start", id);
            return homeRepository.findById(id).get();
        } catch (Exception e) {
            log.error("HomeService find by id Home failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeService find by id Home end");
        }
    }

    @Override
    public List<Home> findAll() {
        try {
            log.info("HomeService find all Homes start");
            return homeRepository.findAll();
        } catch (Exception e) {
            log.error("HomeService find all Homes failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeService find all Homes end");
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            log.info("HomeService delete by id Home(id: {}) start", id);
            homeRepository.deleteById(id);
        } catch (Exception e) {
            log.error("HomeService delete by id Home failure, error: {}", e.getMessage());
        } finally {
            log.info("HomeService delete by id Home end");
        }
    }
}

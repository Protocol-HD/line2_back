package line2.line2_back.home.service;

import line2.line2_back.home.model.Home;
import line2.line2_back.home.model.HomeDto;
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

import java.util.ArrayList;
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

    public void HomePolicyAdd(List<Long> homePolicies, String homePolicyCustom, Home home) {
        homePolicies.forEach(homePolicy -> {
            homePolicyTableRepository.save(
                    HomePolicyTable.builder()
                            .home(home)
                            .homePolicy(homePolicyRepository.findById(homePolicy).get())
                            .build()
            );
        });
        homePolicyTableRepository.save(
                HomePolicyTable.builder()
                        .home(home)
                        .homePolicy(homePolicyRepository.save(
                                HomePolicy.builder()
                                        .homePolicy(homePolicyCustom)
                                        .policyType(3)
                                        .build())
                        )
                        .build()
        );
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
                                            .headCount(0)
                                            .build())
                            )
                            .build()
            );
        });
    }

    @Override
    public SystemMessage add(HomeDto homeDto) {
        try {
            log.info("HomeService save Home({}) start", homeDto);
            Home home = new Home();
            log.info("1. save home");
            home = homeRepository.save(Home.builder()
                    .id(homeDto.getHomeId())
                    .homeName(homeDto.getHomeName())
                    .homeAddress(homeDto.getHomeAddress())
                    .coordinateX(homeDto.getCoordinateX())
                    .coordinateY(homeDto.getCoordinateY())
                    .homeCategory(homeCategoryRepository.findById(homeDto.getHomeCategoryId()).get())
                    .homeInformation(homeDto.getHomeInformation())
                    .hostId(homeDto.getHostId())
                    .homeZipCode(homeDto.getHomeZipCode())
                    .build());

            log.info("2. save home images");
            HomeImageAdd(homeDto.getImages(), home);
            log.info("3. save home policies");
            HomePolicyAdd(homeDto.getHomePolicies(), homeDto.getHomePolicyCustom(), home);
            log.info("4. save home facilities");
            HomeFacilityAdd(homeDto.getHomeFacilities(), home);
            log.info("5. save home rooms");
            HomeRoomAdd(homeDto.getRooms(), home);
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
    public SystemMessage edit(HomeDto homeDto) {
        try {
            log.info("HomeService edit Home({}) start", homeDto);
            Home home = new Home();
            log.info("1. delete home images");
            HomeImageDelete(homeDto.getHomeId());
            log.info("2. delete home policies");
            HomePolicyDelete(homeDto.getHomeId());
            log.info("3. delete home facilities");
            HomeFacilityDelete(homeDto.getHomeId());
            log.info("4. delete home rooms");
            HomeRoomDelete(homeDto.getHomeId());
            add(homeDto);
            return SystemMessage.builder()
                    .code(1)
                    .message("숙소 정보 변경 성공")
                    .build();
        } catch (Exception e) {
            log.error("HomeService save Home failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("숙소 정보 변경 실패")
                    .build();
        } finally {
            log.info("HomeService save Home end");
        }
    }

    @Override
    public HomeDto findById(Long id) {
        try {
            log.info("HomeService find by id Home(id: {}) start", id);
            log.info("1. find home");
            Home home = homeRepository.findById(id).get();
            List<String> images = new ArrayList<String>();
            List<Long> homePolicies = new ArrayList<Long>();
            List<Long> homeFacilities = new ArrayList<Long>();
            List<Room> rooms = new ArrayList<Room>();

            log.info("2. find all home image");
            homeImageTableRepository.findByHomeId(id).forEach(homeImageTable -> {
                images.add(homeImageTable.getImage().getImageName());
            });
            log.info("3. find all home policies");
            homePolicyTableRepository.findByHomeId(id).forEach(homePolicyTable -> {
                homePolicies.add(homePolicyTable.getHomePolicy().getId());
            });
            log.info("4. find all home facilities");
            homeFacilityTableRepository.findByHomeId(id).forEach(homeFacilityTable -> {
                homeFacilities.add(homeFacilityTable.getHomeFacility().getId());
            });
            log.info("5. find all home rooms");
            homeRoomTableRepository.findByHomeId(id).forEach(homeRoomTable -> {
                rooms.add(homeRoomTable.getRoom());
            });

            return HomeDto.builder()
                    .homeId(id)
                    .homeName(home.getHomeName())
                    .homeAddress(home.getHomeAddress())
                    .coordinateX(home.getCoordinateX())
                    .coordinateY(home.getCoordinateY())
                    .homeCategoryId(home.getHomeCategory().getId())
                    .homeInformation(home.getHomeInformation())
                    .hostId(home.getHostId())
                    .homeZipCode(home.getHomeZipCode())
                    .images(images)
                    .homePolicies(homePolicies.subList(0, homePolicies.size() - 1))
                    .homePolicyCustom(homePolicyRepository.findById(homePolicies.get(homePolicies.size() - 1)).get().getHomePolicy())
                    .homeFacilities(homeFacilities)
                    .rooms(rooms)
                    .build();
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

    public void HomeImageDelete(Long id) {
        homeImageTableRepository.findByHomeId(id).forEach(homeImage -> {
            homeImageTableRepository.delete(homeImage);
            imageRepository.deleteById(homeImage.getImage().getId());
        });
    }

    public void HomePolicyDelete(Long id) {
        homePolicyTableRepository.deleteAll(homePolicyTableRepository.findByHomeId(id));
    }

    public void HomeFacilityDelete(Long id) {
        homeFacilityTableRepository.deleteAll(homeFacilityTableRepository.findByHomeId(id));
    }

    public void HomeRoomDelete(Long id) {
        homeRoomTableRepository.findByHomeId(id).forEach(homeRoom -> {
            homeRoomTableRepository.delete(homeRoom);
            roomRepository.deleteById(homeRoom.getRoom().getId());
        });
    }

    @Override
    public SystemMessage deleteById(Long id) {
        try {
            log.info("HomeService delete by id Home(id: {}) start", id);
            log.info("1. delete home images");
            HomeImageDelete(id);
            log.info("2. delete home policies");
            HomePolicyDelete(id);
            log.info("3. delete home facilities");
            HomeFacilityDelete(id);
            log.info("4. delete home rooms");
            HomeRoomDelete(id);
            log.info("5. delete home");
            homeRepository.deleteById(id);
            return SystemMessage.builder()
                    .code(1)
                    .message("숙소 삭제 성공")
                    .build();
        } catch (Exception e) {
            log.error("HomeService delete by id Home failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("숙소 삭제 실패")
                    .build();
        } finally {
            log.info("HomeService delete by id Home end");
        }
    }
}

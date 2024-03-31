package traveladvisor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import traveladvisor.model.entries.Activity;
import traveladvisor.model.entries.Hotel;
import traveladvisor.model.entries.Restaurant;
import traveladvisor.model.entries.Sightseeing;
import traveladvisor.repositories.ActivityRepository;
import traveladvisor.repositories.HotelRepository;
import traveladvisor.repositories.RestaurantRepository;
import traveladvisor.repositories.SightseeingRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Bootstrap implements ApplicationRunner {
	
	private final ActivityRepository activityRepository;
	private final HotelRepository hotelRepository;
	private final SightseeingRepository sightseeingRepository;
	private final RestaurantRepository restaurantRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		List<Activity> activities = activityRepository.findAll();
		activities.stream().map(entry -> {
			entry.updateRating();
			return entry;
		}).collect(Collectors.toList());
		activityRepository.saveAll(activities);
		
		List<Hotel> hotels = hotelRepository.findAll();
		hotels.stream().map(entry -> {
			entry.updateRating();
			return entry;
		}).collect(Collectors.toList());
		hotelRepository.saveAll(hotels);
		
		List<Restaurant> restaurants = restaurantRepository.findAll();
		restaurants.stream().map(entry -> {
			entry.updateRating();
			return entry;
		}).collect(Collectors.toList());
		restaurantRepository.saveAll(restaurants);
		
		List<Sightseeing> sightseeings = sightseeingRepository.findAll();
		sightseeings.stream().map(entry -> {
			entry.updateRating();
			return entry;
		}).collect(Collectors.toList());
		sightseeingRepository.saveAll(sightseeings);
		
		
	}

}

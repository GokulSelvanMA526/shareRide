/*
create a react native screen scrolllable screen for finding rides with the selected location and date with following fields:

1. receive location from the route params
2. receive date from the route params
3. select location
4. select date
5. add filters using dropdown with the following options:
    - seats
    - type of vehicle
    - date
    - gender

use the elements from react-native, react-native-paper, react-native-element-dropdown and react-native-vector-icons libraries:
1. View
2. Text
3. FlatList
4. TouchableOpacity
5. Dimensions
6. Appbar
7. Button
8. Card
9. Icon
10. Dropdown
11. Divider

use the following state variables:
1. filters
2. selectedLocation
3. selectedDate
4. isFocus

use the logic to filter the rides based on the selected filters:
1. filter rides based on the selected location
2. filter rides based on the selected date
3. filter rides based on the selected seats
4. filter rides based on the selected type of vehicle
5. filter rides based on the selected gender

use the following data:
1. generate a list of rides as array of objects with the following fields:
    - id
    - name
    - date
    - seats
    - type of vehicle
    - icon
    - start location
    - end location
    - start time

use the following logic to  design the screen:
1. create a container with styles
2. create a search area with styles
3. create a dropdown with styles inside the search area
4. create a date picker with styles inside the search area
5. create a filter area with styles
6. create a flatlist with styles inside the container
7. create a card with styles inside the flatlist
8. create a card title with styles inside the card and show name of the ride from the list of rides generated
9. create a card content with styles inside the card and show start location, end location, start time and date of the ride from the list of rides generated
10. create a card footer with styles inside the card and show seats, type of vehicle and icon of the ride from the list of rides generated
11. create a button with styles inside the card footer named view ride
12. create a button text with styles inside the button


use the following styles:
1. container: {
    flex: 1,
    backgroundColor: '#fff',
  },
2. searchArea: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    padding: 10,
  },
3. dropdown: {
    width: '48%',
    height: 50,
    borderWidth: 1,
    borderColor: 'grey',
    borderRadius: 5,
    padding: 10,
  },
4. datePicker: {
    width: '48%',
    height: 50,
    borderWidth: 1,
    borderColor: 'grey',
    borderRadius: 5,
    padding: 10,
  },
5. filterArea: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    padding: 10,
  },
6. card: {
    margin: 10,
    padding: 10,
    borderRadius: 5,
    borderWidth: 1,
    borderColor: 'grey',
  },
7. cardTitle: {
    fontSize: 20,
    fontWeight: 'bold',
  },
8. cardContent: {
    fontSize: 16,
  },
9. cardFooter: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    marginTop: 10,
  },
10. button: {
    backgroundColor: 'blue',
    padding: 10,
    borderRadius: 5,
  },
11. buttonText: {
    color: 'white',
    textAlign: 'center',
  },
12. error: {
    color: 'red',
  },
13. success: {
    color: 'green',
  },
14. loading: {
    color: 'blue',
  },
15. icon: {
    width: 50,
    height: 50,
  },
16. iconImage: {
    width: '100%',
    height: '100%',
  },
17. iconText: {
    fontSize: 16,
  },
18. noRides: {
    fontSize: 20,
    textAlign: 'center',
  },
19. noRidesIcon: {
    width: 100,
    height: 100,
    alignSelf: 'center',
  },
20. noRidesText: {
    fontSize: 16,
    textAlign: 'center',
  },
21. noRidesButton: {
    backgroundColor: 'blue',
    padding: 10,
    borderRadius: 5,
    margin: 10,
  },
22. noRidesButtonText: {
    color: 'white',
    textAlign: 'center',
  },
23. noRidesError: {
    color: 'red',
    textAlign: 'center',
  },
24. noRidesSuccess: {
    color: 'green',
    textAlign: 'center',
  },
25. noRidesLoading: {
    color: 'blue',
    textAlign: 'center',
  },
26. noRidesIconImage: {
    width: '100%',
    height: '100%',
  },
27. noRidesIconText: {
    fontSize: 16,
    textAlign: 'center',
  },
28. noRidesIconButton: {
    backgroundColor: 'blue',
    padding: 10,
    borderRadius: 5,
    margin: 10,
  },
29. noRidesIconButtonText: {
    color: 'white',
    textAlign: 'center',
  },
30. noRidesIconError: {
    color: 'red',
    textAlign: 'center',
  },
31. noRidesIconSuccess: {
    color: 'green',
    textAlign: 'center',
  },
32. noRidesIconLoading: {
    color: 'blue',
    textAlign: 'center',
  },
33. noRidesIconError: {
    color: 'red',
    textAlign: 'center',
  },
34. noRidesIconSuccess: {
    color: 'green',
    textAlign: 'center',
  },
35. noRidesIconLoading: {
    color: 'blue',
    textAlign: 'center',
  },
36. noRidesIconImage: {
    width: '100%',
    height: '100%',
  },


use the following functions:
1. handleFilterChange
2. handleDateChange
3. handleViewRidePress
4. handleSelectLocation
5. handleSelectDate
6. handleFilterRides
7. handleResetFilters
8. handleResetDate
9. handleResetLocation
10. handleResetAll
11. handleResetSelected
12. handleResetSelectedLocation
13. handleResetSelectedDate

use the following validations:
1. show error message if location is not selected
2. show error message if date is not selected
3. show error message if location is not provided
4. show error message if date is not provided
5. show error message if location is not a string
6. show error message if date is not a string
7. show error message if location is empty
8. show error message if date is empty
9. show error message if location is not provided in request
10. show error message if date is not provided in request
11. show error message if location is not provided in response
12. show error message if date is not provided in response

use the following data:
1. generate a list of filters as array of objects with the following fields:
    - id
    - name
    - date
    - seats
    - type of vehicle
    - icon
    - start location
    - end location
    - start time
*/

import React, {useState} from 'react';
import {View, Text, FlatList, TouchableOpacity, ScrollView} from 'react-native';
import {Appbar, Button, Divider, IconButton} from 'react-native-paper';
import {Card, Chip, useTheme} from 'react-native-paper';
import {Dropdown} from 'react-native-element-dropdown';
import Icon from '../../components/Icon';
import styles from './FindRide.styles';
import {navigate} from '../../navigation/RootNavigator';

const FindRide = ({route}) => {
  // const {location} = route.params;
  const [selectedLocation, setSelectedLocation] = useState();
  const [selectedDate, setSelectedDate] = useState();
  const [selectedVehicle, setSelectedVehicle] = useState({});
  const [selectedSeats, setSelectedSeats] = useState();
  const [selectedGender, setSelectedGender] = useState();
  const [selectedFilterData, setSelectedFiltersData] = useState([]);
  const [selectedFilter, setSelectedFilter] = useState();
  const [date, setDate] = useState(new Date());
  const [open, setOpen] = useState(false);
  const {colors} = useTheme();

  const [filters, setFilters] = useState([
    {label: 'Seats', value: 'seats'},
    {label: 'Type of Vehicle', value: 'typeOfVehicle'},
    {label: 'Date', value: 'date'},
    {label: 'Gender', value: 'gender'},
  ]);

  const dateFilterOptions = [
    {label: 'All Dates', value: 'all'},
    {label: 'Today', value: 'today'},
    {label: 'Tomorrow', value: 'tomorrow'},
  ];

  // create a data for Type of Vehicle filter dropdown similar to dateFilterOptions
  const typeOfVehicleFilterOptions = [
    {label: 'All Vehicles', value: 'all'},
    {label: 'Car', value: 'car'},
    {label: 'Motorcycle', value: 'motorcycle'},
  ];
  // create a data for gender filter dropdown similar to dateFilterOptions
  const genderFilterOptions = [
    {label: 'All Genders', value: 'all'},
    {label: 'Male', value: 'male'},
    {label: 'Female', value: 'female'},
  ];

  // create a data for seats filter dropdown similar to dateFilterOptions
  const seatsFilterOptions = [
    {label: 'All Seats', value: 'all'},
    {label: '1 Seat', value: '1'},
    {label: '2 Seats', value: '2'},
    {label: '3 Seats', value: '3'},
    // Add more options here
  ];

  const currentDate = new Date();

  const twoDaysLater = new Date();
  twoDaysLater.setDate(currentDate.getDate() + 2);

  // create rides data with the following fields:
  // - id
  // - name
  // - date
  // - seats
  // - type of vehicle
  // - icon
  // - start location
  // - end location
  // - start time

  const rides = [
    {
      id: '1',
      name: 'Ride 1',
      date: '2022-10-10',
      seats: 4,
      typeOfVehicle: 'Car',
      icon: 'car',
      startLocation: 'Location A',
      endLocation: 'Location B',
      startTime: '10:00 AM',
    },
    {
      id: '2',
      name: 'Ride 2',
      date: '2022-10-11',
      seats: 2,
      typeOfVehicle: 'Motorcycle',
      icon: 'bike',
      startLocation: 'Location C',
      endLocation: 'Location D',
      startTime: '12:00 PM',
    },
    // Add more rides here
  ];

  const handleFilterChange = value => {
    console.log('selected filter', value);
    setSelectedFilter(value.value);
    // Implement your filter logic here
  };

  const handleDateChange = value => {
    setSelectedDate(value);
  };

  const handleFilterChanges = value => {
    // write a logic to check if the selected filter is already in the selectedFilterData by checking the type property
    // if it is already in the selectedFilterData, return an error message
    // if it is not in the selectedFilterData, add the selected filter to the selectedFilterData

    const isFilterAlreadySelected = selectedFilterData.some(
      filter => filter.type === selectedFilter,
    );
    if (isFilterAlreadySelected) {
      console.log('Error: Filter already selected');
      return;
    }

    // Add the selected filter to the selectedFilterData
    const combinedData = {
      id: selectedFilterData.length + 1,
      key: selectedFilter + '-' + selectedFilterData.length + 1,
      type: selectedFilter,
      ...value,
    };
    console.log('selected filter', combinedData, value);
    setSelectedFiltersData([...selectedFilterData, combinedData]);
    // if selected filter is 'date', set the selectedDate to the value
    // if selected filter is 'typeOfVehicle', set the selectedVehicle to the value
    // if selected filter is 'seats', set the selectedSeats to the value
    // if selected filter is 'gender', set the selectedGender to the value

    if (selectedFilter === 'date') {
      setSelectedDate(value);
    } else if (selectedFilter === 'typeOfVehicle') {
      setSelectedVehicle(value);
    } else if (selectedFilter === 'seats') {
      setSelectedSeats(value);
    } else if (selectedFilter === 'gender') {
      setSelectedGender(value);
    }

    // Implement your filter logic here
  };

  // write a function to remove the selected filter from the selectedFilterData
  const handleRemoveFilter = filterId => {
    const newData = selectedFilterData.filter(filter => filter.id !== filterId);
    setSelectedFiltersData([...newData]);
  };

  const handleViewRidePress = rideId => {
    // Implement your logic here
    navigate('JoinRide', {rideId});
  };

  const navigateHome = () => {
    navigate('Home');
  };

  // create a function to iterate and produce Chip component for each filter from the selectedFilters
  type SelectedFilter = {
    id: string;
    name: string;
    icon: string; // Add the 'icon' property to the type definition
  };

  const renderSelectedFilters = () => {
    return selectedFilterData.map((filter: any) => {
      // Specify the type of 'filter' as 'SelectedFilter'
      console.log('filter', filter);
      return (
        <Chip
          style={styles.chips}
          key={filter.id}
          icon={filter.icon}
          onClose={() => handleRemoveFilter(filter.id)}>
          {filter.label}
        </Chip>
      );
    });
  };

  const resetAllFilters = () => {
    setSelectedFiltersData([]);
    setSelectedDate('');
    setSelectedVehicle('');
    setSelectedSeats('');
    setSelectedGender('');
  };

  const resetButtonComponent = () => {
    // create a chip component with the label 'Reset All Filters' and onPress event to reset all filters call the resetAllFilters function
    return (
      <Chip style={styles.chips} onClose={() => resetAllFilters()}>
        Reset All Filters
      </Chip>
    );
  };

  return (
    <>
      <Appbar.Header>
        <Appbar.BackAction onPress={navigateHome} />
        <Appbar.Content title="Find Ride" />
      </Appbar.Header>
      <View style={styles.container}>
        <View
          style={[
            styles.searchArea,
            {
              backgroundColor: colors.primary,
            },
          ]}>
          <Dropdown
            style={styles.dropdown}
            data={filters}
            placeholder="Select Filter"
            onChange={handleFilterChange}
            labelField={'label'}
            valueField={'value'}
          />
          {selectedFilter === 'date' && (
            <Dropdown
              style={styles.dropdown}
              data={dateFilterOptions}
              placeholder="Select Date"
              onChange={handleFilterChanges}
              labelField={'label'}
              valueField={'value'}
            />
          )}
          {selectedFilter === 'typeOfVehicle' && (
            <Dropdown
              style={styles.dropdown}
              data={typeOfVehicleFilterOptions}
              placeholder="Select Type of Vehicle"
              onChange={handleFilterChanges}
              value={selectedVehicle}
              labelField={'label'}
              valueField={'value'}
            />
          )}
          {selectedFilter === 'seats' && (
            <Dropdown
              style={styles.dropdown}
              data={seatsFilterOptions}
              placeholder="Select Seats"
              onChange={handleFilterChanges}
              value={selectedSeats}
              labelField={'label'}
              valueField={'value'}
            />
          )}
          {selectedFilter === 'gender' && (
            <Dropdown
              style={styles.dropdown}
              data={genderFilterOptions}
              placeholder="Select Gender"
              onChange={handleFilterChanges}
              value={selectedGender}
              labelField={'label'}
              valueField={'value'}
            />
          )}
        </View>
        <View style={[styles.filterArea, {backgroundColor: colors.primary}]}>
          <Divider />
          {selectedFilterData && renderSelectedFilters()}
          {selectedFilterData.length > 0 && resetButtonComponent()}
        </View>
        <View style={styles.cardsContainer}>
          <FlatList
            data={rides}
            renderItem={({item}) => (
              <Card style={styles.card}>
                <Card.Title
                  title={item.name}
                  titleVariant="displayMedium"
                  titleStyle={styles.cardTitle}
                />
                <Card.Content>
                  <Text style={styles.cardContent}>
                    {item.startLocation} - {item.endLocation}
                  </Text>
                  <Text style={styles.cardContent}>
                    {item.date} - Starts at {item.startTime}
                  </Text>
                </Card.Content>
                <Card.Actions style={styles.cardFooter}>
                  <Icon name="car" size={20} color="black" />
                  <IconButton icon="bike" size={20} />
                  <Text>Seats Available - {item.seats}</Text>
                  {/* <Text>{item.typeOfVehicle}</Text> */}
                  <Button
                    style={styles.button}
                    onPress={() => handleViewRidePress(item.id)}>
                    <Text style={styles.buttonText}>View Ride</Text>
                  </Button>
                </Card.Actions>
              </Card>
            )}
            keyExtractor={item => item.id}
          />
        </View>
      </View>
    </>
  );
};

export default FindRide;

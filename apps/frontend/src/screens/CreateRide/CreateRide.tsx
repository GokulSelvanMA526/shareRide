/*
create a react native screen for creating a ride with following fields:
1. source
2. destination
3. date
4. time
5. seats
6. create ride button
7. type of vehicle
8. vehicle number
9. vehicle color
10. vehicle model

use the elements from react-native and react-native-vector-icons libraries:
1. View
2. Text
3. TextInput
4. Button
5. Icon
6. Picker
7. DatePicker
8. TimePicker

follow the given structure:
1. create a container with styles
2. create form container with styles

5. crate text showing field name with styles inside form container
3. create source input field with styles inside form container

5. crate text showing field name with styles inside form container
4. create destination input field with styles inside form container
5. crate text showing field name with styles inside form container
5. create date DatePicker field with styles inside form container
6. create time timepicker field with styles inside form container
7. create seats Dropdown field with styles inside form container
8. create type of vehicle input field with styles inside form container
9. create vehicle number input field with styles inside form container
10. create vehicle color input field with styles inside form container
11. create vehicle model input field with styles inside form container
12. create create ride button with styles inside form container
13. create error message with styles below source input field and destination input field
14. create success message with styles below create ride button
15. create loading indicator with styles below create ride button
16. place the form container inside the container and center of the screen
17. create form container background color as white


use the following state variables:
1. source
2. destination
3. date
4. time
5. seats
6. type of vehicle
7. vehicle number
8. vehicle color
9. vehicle model

use icon for source, destination, date, time, seats, type of vehicle, vehicle number, vehicle color, vehicle model input fields:
1. source: <Icon name="source" size={20} color="black" />
2. destination: <Icon name="destination" size={20} color="black" />
3. date: <Icon name="date" size={20} color="black" />
4. time: <Icon name="time" size={20} color="black" />
5. seats: <Icon name="seats" size={20} color="black" />
6. type of vehicle: <Icon name="type of vehicle" size={20} color="black" />
7. vehicle number: <Icon name="vehicle number" size={20} color="black" />
8. vehicle color: <Icon name="vehicle color" size={20} color="black" />
9. vehicle model: <Icon name="vehicle model" size={20} color="black" />
10. create ride: <Icon name="create ride" size={20} color="black" />

use the following functions:
1. setSource
2. setDestination
3. setDate
4. setTime
5. setSeats
6. setTypeOfVehicle
7. setVehicleNumber
8. setVehicleColor

use the following validations:
1. source should be a valid string
2. destination should be a valid string
3. date should be a valid date
4. time should be a valid time
5. seats should be a valid number
6. type of vehicle should be a valid string
7. vehicle number should be a valid string
8. vehicle color should be a valid string
9. vehicle model should be a valid string
10. show error message if source or destination is invalid below the respective input field
11. show error message if date or time is invalid below the respective input field
12. show error message if seats is invalid below the respective input field
13. show error message if type of vehicle is invalid below the respective input field
14. show error message if vehicle number is invalid below the respective input field
15. show error message if vehicle color is invalid below the respective input field
16. show error message if vehicle model is invalid below the respective input field
17. show error message if create ride api fails
18. show loading indicator while api is in progress
19. show success message on successful create ride
20. show error message on unsuccessful create ride
21. show error message if source or destination is empty
22. show error message if date or time is empty
23. show error message if seats is empty
24. show error message if type of vehicle is empty
25. show error message if vehicle number is empty
26. show error message if vehicle color is empty
27. show error message if vehicle model is empty
28. show error message if source or destination is not provided
29. show error message if date or time is not provided
30. show error message if seats is not provided
31. show error message if type of vehicle is not provided
32. show error message if vehicle number is not provided
33. show error message if vehicle color is not provided
34. show error message if vehicle model is not provided
35. show error message if source or destination is not a string
36. show error message if date or time is not a string
37. show error message if seats is not a number
38. show error message if type of vehicle is not a string
39. show error message if vehicle number is not a string
40. show error message if vehicle color is not a string
41. show error message if vehicle model is not a string

use the following styles:
container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: 'lightgrey',
},
formContainer: {
    width: '80%',
    padding: 10,
    backgroundColor: 'white',
},
input: {
    borderWidth: 1,
    borderRadius: 5,
    padding: 10,
    margin: 5,
},
button: {
    backgroundColor: 'blue',
    padding: 10,
    margin: 5,
    borderRadius: 5,
},
error: {
    color: 'red',
},
success: {
    color: 'green',
},
loading: {
    color: 'blue',
},

use the following data for seats dropdown:
- [1, 2, 3, 4, 5]
- default value should be 1 for 2 seater vehicle
- default value should be 1 for 4 seater vehicle
- default value should be 1 for 5 seater vehicle
- default value should be 1 for 6 seater vehicle
- minimum value should be 1 for all vehicle
- maximum value should be 5 for all vehicle

use the following data for type of vehicle dropdown:
- [car, bike]
- default value should be car
- default value should be bike
- show error message if type of vehicle is not selected

use the following data for vehicle color dropdown:
- [red, blue, green, black, white]
- default value should be red

use the following data for vehicle model dropdown:
- [honda, suzuki, yamaha, bmw, audi]
- default value should be honda
- show error message if vehicle model is not selected

use the following data for vehicle number input field:
- default value should be empty
- show error message if vehicle number is empty
- show error message if vehicle number is not a string
- generate some random vehicle number for testing purpose
- show error message if vehicle number is not provided
- show error message if vehicle number is not provided in request

use the following data for source input field:
- source list should be list of local areas in Chennai

use the following data for destination input field:
- destination list should be CIEC, Chennai
- show error message if destination is not CIEC, Chennai

use the following data for date input field:
- date should be current date
- show error message if date is not a valid date
- show error message if date is not provided
- show error message if date is not provided in request

use the following data for time input field:
- time should be current time
- show error message if time is not a valid time
- show error message if time is not provided
- show error message if time is not provided in request


use the following data for create ride button:
- create ride button should be disabled if any of the input fields are invalid
- create ride button should be enabled if all the input fields are valid
- create ride button should show loading indicator while api is in progress
- create ride button should show success message on successful create ride
- create ride button should show error message on unsuccessful create ride

use the following data for error message:
- error message should be displayed below the respective input field
- error message should be displayed in red color
- error message should be displayed in case of invalid input
- error message should be displayed in case of api failure


*/

import React, {useEffect, useState} from 'react';
import {
  View,
  Text,
  TextInput,
  ScrollView,
  TouchableOpacity,
} from 'react-native';
import {Button} from 'react-native-paper';
import Icon from 'react-native-vector-icons/Ionicons';
import {Dropdown} from 'react-native-element-dropdown';

import DatePicker from 'react-native-date-picker';
import styles from './CreateRide.styles';
import {Appbar, Text as PaperText} from 'react-native-paper';
import {navigate} from '../../navigation/RootNavigator';

const CreateRide = ({navigation, route}) => {
  const [source, setSource] = useState('');
  const [destination, setDestination] = useState('');
  const [time, setTime] = useState('');
  const [seats, setSeats] = useState(1);
  const [typeOfVehicle, setTypeOfVehicle] = useState('car');
  const [vehicleNumber, setVehicleNumber] = useState('');
  const [vehicleColor, setVehicleColor] = useState('red');
  const [vehicleModel, setVehicleModel] = useState('honda');
  const [error, setError] = useState('');
  const [success, setSuccess] = useState('');
  const [loading, setLoading] = useState(false);
  const [date, setDate] = useState(new Date());
  const [open, setOpen] = useState(false);
  const currentDate = new Date();

  const twoDaysLater = new Date();
  twoDaysLater.setDate(currentDate.getDate() + 2);

  const someParameter = route.params;
  console.log('someParameter', someParameter);

  const seatsData = [
    {label: 1, value: 1},
    {label: 2, value: 2},
    {label: 3, value: 3},
    {label: 4, value: 4},
    {label: 5, value: 5},
  ];
  const typeOfVehicleData = [
    {label: 'car', value: 'car'},
    {label: 'bike', value: 'bike'},
  ];
  const vehicleColorData = [
    {label: 'red', value: 'red'},
    {label: 'blue', value: 'blue'},
    {label: 'green', value: 'green'},
    {label: 'black', value: 'black'},
    {label: 'white', value: 'white'},
  ];

  const vehicleModelData = [
    {label: 'honda', value: 'honda'},
    {label: 'suzuki', value: 'suzuki'},
    {label: 'yamaha', value: 'yamaha'},
    {label: 'bmw', value: 'bmw'},
    {label: 'audi', value: 'audi'},
  ];

  useEffect(() => {
    console.log(date, 'date');
  }, [date]);

  // change the vehicleColorData to array of objects with label and value
  //   const formattedVehicleColorData = vehicleModelData.map(color => ({
  //     label: color,
  //     value: color,
  //   }));
  const createRide = () => {
    if (!source) {
      setError('Please enter source');
      return;
    }
    if (!destination) {
      setError('Please enter destination');
      return;
    }
    if (!date) {
      setError('Please enter date');
      return;
    }
    if (!time) {
      setError('Please enter time');
      return;
    }
    if (!seats) {
      setError('Please enter seats');
      return;
    }
    if (!typeOfVehicle) {
      setError('Please enter type of vehicle');
      return;
    }
    if (!vehicleNumber) {
      setError('Please enter vehicle number');
      return;
    }
    if (!vehicleColor) {
      setError('Please enter vehicle color');
      return;
    }
    if (!vehicleModel) {
      setError('Please enter vehicle model');
      return;
    }

    setLoading(true);
    // Call API to create ride
    setLoading(false);
    setSuccess('Ride created successfully');
  };

  const navigateHome = () => {
    navigate('Home');
  };

  return (
    <ScrollView>
      <Appbar.Header>
        <Appbar.BackAction onPress={navigateHome} />
        <Appbar.Content title="Create Ride" />
      </Appbar.Header>
      <View style={styles.container}>
        <View style={styles.formContainer}>
          <PaperText variant="titleMedium">Start</PaperText>
          <View style={styles.input}>
            <Icon name="alarm" size={20} color="black" />
            <TextInput
              placeholder="Source"
              value={source}
              onChangeText={setSource}
            />
          </View>
          <PaperText variant="titleMedium">End</PaperText>
          <View style={styles.input}>
            <Icon name="alarm" size={20} color="black" />
            <TextInput
              placeholder="Destination"
              value={destination}
              onChangeText={setDestination}
            />
          </View>
          <PaperText variant="titleMedium">Date</PaperText>
          <TouchableOpacity
            style={{width: 100, height: 50, backgroundColor: 'lightgrey'}}
            onPress={() => setOpen(true)}>
            <DatePicker
              modal
              open={open}
              date={date}
              onConfirm={date => {
                console.log(typeof date, date.toLocaleString(), 'date');
                setOpen(false);
                setDate(date);
              }}
              onCancel={() => {
                setOpen(false);
              }}
              minimumDate={new Date(currentDate)}
              maximumDate={new Date(twoDaysLater)}
              minuteInterval={10}
              dividerColor="blue"
            />
          </TouchableOpacity>
          <PaperText variant="titleMedium">Seats</PaperText>
          <View style={styles.input}>
            <Icon name="alarm" size={20} color="black" />
            <Dropdown
              data={seatsData}
              value={seats}
              onChange={setSeats}
              labelField="label"
              valueField="value"
            />
          </View>
          <PaperText variant="titleMedium">Type of Vehicle</PaperText>
          <View style={styles.input}>
            <Icon name="alarm" size={20} color="black" />
            <Dropdown
              data={typeOfVehicleData}
              value={typeOfVehicle}
              onChange={setTypeOfVehicle}
              labelField="label"
              valueField="value"
            />
          </View>
          <PaperText variant="titleMedium">Vehicle Number</PaperText>
          <View style={styles.input}>
            <Icon name="alarm" size={20} color="black" />
            <TextInput
              placeholder="Vehicle Number"
              value={vehicleNumber}
              onChangeText={setVehicleNumber}
            />
          </View>
          <PaperText variant="titleMedium">Vehicle Color</PaperText>
          <View style={styles.input}>
            <Icon name="alarm" size={20} color="black" />
            <Dropdown
              data={vehicleColorData}
              value={vehicleColor}
              onChange={setVehicleColor}
              labelField="label"
              valueField="value"
            />
          </View>
          <PaperText variant="titleMedium">Start</PaperText>
          <View style={styles.input}>
            <Icon name="alarm" size={20} color="black" />
            <Dropdown
              data={vehicleColorData}
              value={vehicleColor}
              onChange={setVehicleColor}
              labelField="label"
              valueField="value"
            />
          </View>
          <PaperText variant="titleMedium">Vehicle Model</PaperText>
          <View style={styles.input}>
            <Icon name="alarm" size={20} color="black" />
            <Dropdown
              data={vehicleModelData}
              value={vehicleModel}
              onChange={setVehicleModel}
              labelField="label"
              valueField="value"
            />
          </View>
          <Button mode="contained" onPress={createRide}>
            Create Ride
          </Button>
          {error ? <Text style={styles.error}>{error}</Text> : null}
          {success ? <Text style={styles.success}>{success}</Text> : null}
          {loading ? <Text style={styles.loading}>Loading...</Text> : null}
        </View>
      </View>
    </ScrollView>
  );
};

export default CreateRide;

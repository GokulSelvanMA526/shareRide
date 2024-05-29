/*
create a  react native screen called JoinRide that displays a Details screen with the following fields:
- rideId
- RideOwner
- date
- seats
- type of vehicle
- icon
- start location
- end location
- start time
- a button to join the ride
- select and display the ride details based on the rideId passed as a parameter
- seats should be displayed as a dropdown with the following options:
    - 1
    - 2
    - 3
    - 4
    - 5

use the elements from react-native, react-native-paper, react-native-element-dropdown and react-native-vector-icons libraries:
1. View from react-native
2. Text from react-native
3. FlatList from react-native
4. TouchableOpacity from react-native
5. Dimensions from react-native
6. Appbar from react-native-paper
7. Button from react-native-paper
8. Card from react-native-paper
9. Icons from react-native-vector-icons
10. Dropdown from react-native-element-dropdown
11. Divider from react-native-paper
12. TextInput from react-native-paper
13. Snackbar from react-native-paper

use the colors from the theme:
1. primary from the theme
2. secondary from the theme
3. background from the theme
4. text from the theme

use the following state variables:
1. rideId
2. rideOwner

use the following logic to design the screen:
1. create a container with styles
2. create a card with styles inside the container
3. create a card showing the ride details with styles inside the card
4. create a card title with styles inside the card and show name of the ride
5. create a dropdown with styles inside the card and show seats as dropdown with the following options:
    - 1
    - 2
    - 3
    - 4
    - 5
6. create a card content with styles inside the card and show start location, end location, start time and date of the ride
7. create a card footer with styles inside the card and show type of vehicle and icon of the ride
8. create a button with styles inside the card footer named join ride
9. create a button text with styles inside the button and text should be Join Ride
11. create a Appbar with text Join Ride and should have appbar actions with icon back 
12. create a Snackbar with text Ride joined successfully

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

use the following styles:
1. container: {
    flex: 1,
    backgroundColor: theme.colors.background,
    padding: 16,
  },
  card: {
    marginVertical: 8,
    elevation: 2,
    backgroundColor: theme.colors.surface,
    borderRadius: 8,
  },
  cardTitle: {
    fontSize: 16,
    fontWeight: 'bold',
    color: theme.colors.text,
    padding: 16,
  },
  cardContent: {
    padding: 16,
  },
  cardFooter: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    padding: 16,
  },
  button: {
    width: '100%',
    padding: 8,
    backgroundColor: theme.colors.primary,
  },
  buttonText: {
    color: theme.colors.text,
    textAlign: 'center',
  },
}

use the following navigation logic:
1. create a navigation stack with screens JoinRide and Details
2. navigate to the Details screen when the user clicks on the join ride button
3. pass the rideId as a parameter to the Details screen
4. pass the rideOwner as a parameter to the Details screen
5. pass the date as a parameter to the Details screen



// Solution:
import React, { useState } from 'react';
*/

import React, {useState} from 'react';
import {View, Text, FlatList, TouchableOpacity} from 'react-native';
import {Appbar, Button, Card, Divider, Snackbar} from 'react-native-paper';
import {Dropdown} from 'react-native-element-dropdown';
import {FontAwesome} from 'react-native-vector-icons';
import {useTheme} from 'react-native-paper';

import {styles} from './JoinRide.styles';

const JoinRide = ({route, navigation}) => {
  const {colors} = useTheme();
  // const {rideId = 1, rideOwner, date} = route.params;
  const rideId = 1;
  const [selectedSeats, setSelectedSeats] = useState(1);
  const [snackbarVisible, setSnackbarVisible] = useState(false);

  // const ride = rides.find(r => r.id === rideId);

  const handleJoinRide = () => {
    setSnackbarVisible(true);
  };

  // create a ride data with the fields used in this component

  const ride = {
    rideId: 1,
    rideOwner: 'John Doe',
    date: '2022-01-01',
    seats: 4,
    vehicle: 'car',
    icon: 'car',
    startLocation: 'Tambaram',
    endLocation: 'CIEC',
    startTime: '11:00',
    name: 'Ride 1',
  };

  return (
    <View style={styles.container}>
      <Appbar.Header>
        <Appbar.BackAction onPress={() => navigation.goBack()} />
        <Appbar.Content title="Join Ride" />
      </Appbar.Header>
      <Card style={styles.card}>
        <Card.Title title={ride.name} />
        {/* <Card.Content> */}
        {/* <Dropdown
            label="Seats"
            value={selectedSeats}
            options={[1, 2, 3, 4, 5]}
            onChange={value => setSelectedSeats(value)}
          /> */}
        {/* <Text style={styles.cardContent}>
            {ride.startLocation} to {ride.endLocation}
          </Text>
          <Text style={styles.cardContent}>
            {ride.startTime} on {ride.date}
          </Text> */}
        {/* </Card.Content> */}
        {/* <Card.Actions>
          <View style={styles.cardFooter}>
            <Text style={styles.cardContent}>{ride.vehicle}</Text>
          </View>
        </Card.Actions> */}
        <Button style={styles.button} onPress={handleJoinRide}>
          <Text style={styles.buttonText}>Join Ride</Text>
        </Button>
      </Card>
    </View>
  );
};

export default JoinRide;

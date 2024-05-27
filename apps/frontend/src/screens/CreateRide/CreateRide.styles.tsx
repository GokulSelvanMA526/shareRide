// Path: apps/frontend/src/screens/CreateRide/CreateRide.styles.tsx
/*
create a stylesheet for CreateRide screen with following styles:
1. container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: 'lightgrey',
},
2. formContainer: {
    width: '80%',
    padding: 10,
    backgroundColor: 'white',
},

3. input: {
    borderWidth: 1,
    borderRadius: 5,
    padding: 10,
    margin: 5,
},
4. button: {
    backgroundColor: 'blue',
    padding: 10,
    margin: 5,
    borderRadius: 5,
},
5. error: {
    color: 'red',
},
6. success: {
    color: 'green',
},
7. loading: {
    color: 'blue',
},
*/

import {StyleSheet} from 'react-native';

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: 'lightgrey',
    padding: 6,
  },
  formContainer: {
    width: '98%',
    padding: 10,
    backgroundColor: 'white',
    borderRadius: 5,
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
});

export default styles;

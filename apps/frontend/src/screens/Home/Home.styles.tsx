import {StyleSheet} from 'react-native';
const styles = StyleSheet.create({
  container: {
    backgroundColor: 'white',
    padding: 16,
  },
  dropdown: {
    height: 50,
    borderColor: 'gray',
    borderWidth: 0.5,
    borderRadius: 8,
    paddingHorizontal: 8,
  },
  icon: {
    marginRight: 5,
  },
  label: {
    position: 'absolute',
    backgroundColor: 'white',
    left: 22,
    top: 8,
    zIndex: 999,
    paddingHorizontal: 8,
    fontSize: 14,
  },
  placeholderStyle: {
    fontSize: 16,
  },
  selectedTextStyle: {
    fontSize: 16,
  },
  iconStyle: {
    width: 20,
    height: 20,
  },
  inputSearchStyle: {
    height: 40,
    fontSize: 16,
  },
  item: {
    marginHorizontal: 3,
    marginVertical: 3,
  },
  destinationView: {
    height: 50,
    borderColor: 'gray',
    borderWidth: 0.5,
    borderRadius: 8,
    paddingHorizontal: 8,
  },
  destinationText: {
    marginTop: 12,
    fontSize: 14,
    color: '#333',
  },
  shuffleIcon: {
    position: 'absolute',
    right: 10,
    zIndex: 1,
    borderBlockColor: 'black',
    borderRadius: 50,
    padding: 5,
  },
  searchArea: {position: 'relative', marginHorizontal: 6, marginVertical: 2},
});

export default styles;

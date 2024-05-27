import {StyleSheet} from 'react-native';

const styles = StyleSheet.create({
  container: {
    backgroundColor: 'lightgreen',
    flex: 1,
  },
  searchArea: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    padding: 10,
  },
  filterArea: {
    flexDirection: 'row',
    justifyContent: 'flex-start',
    padding: 10,
  },
  chips: {
    marginRight: 5,
  },
  dropdown: {
    flex: 1,
    marginRight: 5,
    borderWidth: 1.5,
    borderColor: 'black',
    padding: 5,
    borderRadius: 5,
  },
  datePicker: {
    flex: 1,
    height: 40,
    borderColor: '#ccc',
    borderWidth: 1,
    justifyContent: 'center',
    paddingLeft: 10,
  },
  cardsContainer: {
    flex: 1,
    padding: 6,
    backgroundColor: 'white',
  },
  card: {
    marginBottom: 10,
    borderColor: 'black',
    borderWidth: 1.5,
  },
  cardTitle: {
    fontSize: 16,
    fontWeight: 'bold',
  },
  cardContent: {
    fontSize: 14,
    color: '#555',
  },
  cardFooter: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
  },
  button: {
    backgroundColor: '#007BFF',
    paddingHorizontal: 10,
    paddingVertical: 5,
  },
  buttonText: {
    color: '#fff',
  },
});

export default styles;

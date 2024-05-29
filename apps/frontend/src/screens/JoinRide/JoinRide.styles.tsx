import {StyleSheet} from 'react-native';

// const {colors} = useTheme();
export const styles = StyleSheet.create({
  container: {
    flex: 1,
    // backgroundColor: colors.background,
    // padding: 16,
  },
  card: {
    marginVertical: 8,
    marginHorizontal: 16,
    elevation: 2,
    // backgroundColor: colors.surface,
    borderRadius: 8,
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
    // backgroundColor: colors.primary,
  },
  buttonText: {
    // color: colors.text,
    textAlign: 'center',
  },
});

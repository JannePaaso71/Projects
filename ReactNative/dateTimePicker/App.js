import { StatusBar } from 'expo-status-bar';
import React, { useState } from 'react';
import { StyleSheet, View, Text, Pressable } from 'react-native';
import DateTimePicker from '@react-native-community/datetimepicker';
import dayjs from 'dayjs';


export default function App() {
  const [date, setDate] = useState(dayjs().toDate());
  const [show, setShow] = useState(false);

  const pickDate = () => {
    setShow(true);
  };

  const onChange = (event, selectedDate) => {
    const currentDate = selectedDate || date;
    setShow(false);
    setDate(currentDate);
  };

  const DisplayDate = () => {
    return <Text>{dayjs(date).locale('fi').format('DD.MM.YYYY')}</Text>;
  };

  return (
    <View style={styles.container}>
      <Pressable onPress={pickDate}>
        <DisplayDate />
      </Pressable>
      {show &&
        <DateTimePicker
          value={date}
          mode="date"
          display="default"
          onChange={onChange}
        />
      }
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
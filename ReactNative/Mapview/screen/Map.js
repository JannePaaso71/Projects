import styles from "../styles/Style";
import MapView from "react-native-maps";
import React, {useState, useEffect} from 'react';
import {getUserPosition} from "../utils/AsyncGetPositionUtils";

export default function Map(location) {


    // useEffect(() => {
    //     getUserPosition(location, setLocation)
    // }, []);

    return (
        <MapView
            style={styles.map}
            region={location}
        />
    )
}



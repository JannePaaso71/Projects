import React from "react";
import { Appbar } from "react-native-paper";

export default function MainAppBar(props) {
    return (
        <Appbar.Header style={{ backgroundColor: props.backgroundColor }}>
            <Appbar.BackAction onPress={() => console.log("Back pressed")} />
            <Appbar.Content title={props.title} />
            <Appbar.Action
                icon={props.icon}
                onPress={props.getUserPosition} // Call the function passed as a prop
            />
        </Appbar.Header>
    );
}

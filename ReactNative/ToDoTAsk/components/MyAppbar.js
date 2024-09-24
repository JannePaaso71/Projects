import {Appbar} from "react-native-paper";
import Styles from "../styles/Styles";

export default function MyAppbar() {
    return (
        <Appbar.Header style={Styles.appbar}>
            <Appbar.Content title="Todo list" />
        </Appbar.Header>
    )
}
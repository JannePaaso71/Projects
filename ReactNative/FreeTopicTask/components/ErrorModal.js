import React, { useEffect, useState } from 'react'
import { Modal, View, Text, Button } from 'react-native'
import { styles } from '../styles/Style'

const ErrorModal = ({ error, onClose }) => {
    const [visible, setVisible] = useState(false)

    useEffect(() => {
        if (error) {
            setVisible(true)
        } else {
            setVisible(false)
        }
    }, [error]);

    return (
        <Modal
            animationType="slide"
            transparent={true}
            visible={visible}
            onRequestClose={onClose}
        >
            <View style={styles.modalContainer}>
                <View style={styles.modalContent}>
                    <Text style={styles.errorMessage}>{error}</Text>
                    <Button title="Close" onPress={onClose} />
                </View>
            </View>
        </Modal>
    );
};

export default ErrorModal;
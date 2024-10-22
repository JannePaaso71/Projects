import {initializeApp} from 'firebase/app';
import {getFirestore, collection, addDoc, serverTimestamp, query, onSnapshot, orderBy} from 'firebase/firestore';
import {getAuth} from "firebase/auth";

// Import the functions you need from the SDKs you need
//import { initializeApp } from "firebase/app";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
const firebaseConfig = {
    apiKey: "AIzaSyCD4DL1_PwhZclZ5ubweo9_KlCAIpXpwGg",
    authDomain: "chat-2ff94.firebaseapp.com",
    projectId: "chat-2ff94",
    storageBucket: "chat-2ff94.appspot.com",
    messagingSenderId: "157630177389",
    appId: "1:157630177389:web:3e9811248bb68471b65f64"
};


//initializeApp(firebaseConfig);
// Initialize Firebase
const app = initializeApp(firebaseConfig);

const firestore = getFirestore(app);
const MESSAGES = "messages";
const auth = getAuth(app);

export {
    app,
    firestore,
    MESSAGES,
    collection,
    addDoc,
    serverTimestamp,
    query,
    onSnapshot,
    orderBy,
    auth
}
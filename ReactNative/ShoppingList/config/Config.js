import { initializeApp } from "firebase/app";
import { getFirestore, collection, addDoc, serverTimestamp, query, onSnapshot, deleteDoc, doc, updateDoc } from "firebase/firestore";


const firebaseConfig = {
    apiKey: "AIzaSyCntWALOX_nUZeQ9Q7mmYQ1mewNZaEIK1g",
    authDomain: "shoppinglist-abebf.firebaseapp.com",
    projectId: "shoppinglist-abebf",
    storageBucket: "shoppinglist-abebf.appspot.com",
    messagingSenderId: "417992349171",
    appId: "1:417992349171:web:92349dbea5338620fe2e86"
};

const app = initializeApp(firebaseConfig);
const firestore = getFirestore(app);
const MESSAGES = 'messages';

export {
    firestore,
    collection,
    addDoc,
    MESSAGES,
    serverTimestamp,
    query,
    onSnapshot,
    deleteDoc,
    doc,
    updateDoc
}

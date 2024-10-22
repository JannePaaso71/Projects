

export const convertFirebaseTimeStampToJS = (timestamp) => {
    if (timestamp !== null && timestamp !== undefined) {
        const firebasetime = new Date(timestamp.seconds * 1000 + timestamp.nanoseconds / 1000000);
        const result =
            firebasetime.getDate() + '.' +
            (firebasetime.getMonth() + 1) + '.' +
            firebasetime.getFullYear() + ' ' +
            firebasetime.getHours() + ':' +
            String(firebasetime.getMinutes()).padStart(2, '0') + '.' +
            String(firebasetime.getSeconds()).padStart(2, '0')
        return result
    } else {
        return ''
    }
}
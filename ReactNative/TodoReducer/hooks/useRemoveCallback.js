import {useCallback} from "react";


export default function useRemoveCallback(dispatch) {
    const remove = useCallback((id) => {
        dispatch({type: "DELETE", payload: id});
    }, []);

    return remove;
}
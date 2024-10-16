import { useMemo } from 'react';

export default function useFilterMemo(todos, search) {
    const items = useMemo(() =>
        search.length > 0 ?
            todos.filter((todo) =>
                todo.description.toLowerCase().startsWith(search.toLowerCase())) :
            todos, [search, todos]);

    return items;
}
export interface UpdateById<T,D>{
    id:D;
    body:T;
}

export interface UpdateMulti<T>{
    list:T[]
}
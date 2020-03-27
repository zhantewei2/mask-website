let fn=()=>{
    console.log(1);
    return 1;
}
const old=fn;
fn=()=>{
    if(old());
    console.log(23);

}


fn();
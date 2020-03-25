const {Subject,of,throwError} =require("rxjs");
const {catchError,tap,finalize} =require("rxjs/operators");

const subject=new Subject();

subject.pipe(
    catchError(()=>{
        return throwError("1")
    }),
    finalize(e=>{
        console.log("tap",e)
    })
).subscribe(res=>{
    console.log(res)
},e=>{
    console.log("err",e);
});

subject.next("2");

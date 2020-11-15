const express = require('express');
const app = express();
let users = [ { id : 1, name : '1번 테이블'},
{ id : 2, name : '2번 테이블'},
{ id : 3, name : '3번 테이블'},
{ id : 4, name : '4번 테이블'}]

app.get('/users',(req,res) => {
    console.log('who get in here/users');
    res.json(users)
});

app.listen(3000, () => {
    console.log('Example app listening on port 3000!');
});
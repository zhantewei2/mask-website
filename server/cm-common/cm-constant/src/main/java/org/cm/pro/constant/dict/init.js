var fs = require('fs');

var packageName = 'package org.cm.pro.constant.dict;';
var dictClassName = 'DictDataEnum';

fs.readFile('数据字典枚举值定义-持续更新.txt',function(err, data) {
    if(err){
        console.log('读取数据字典文件失败!');
        return;
    }
    console.log('读取文件成功 开始处理文件...');
    var stringArray = data.toString().split('\n');
    for (var i = 0; i < stringArray.length; i++) {
        var str = stringArray[i];
        if (str.length > 0) {
            var val = '    public static final String ' + str;
            stringArray[i] = val;
        }
    }
    console.log('处理文件成功 开始写入...');
    var dictClassContentStr = stringArray.join('\n');
    var dictClassPrefix = 'public class ' + dictClassName + ' { \n';
    var dictClassSuffix = '\n}';
    var finalStr = packageName + '\n\n' + dictClassPrefix + dictClassContentStr + dictClassSuffix;
    fs.writeFile(dictClassName + '.java', finalStr,'utf8',function(err){
        if(err){
            console.log(err);
            return;
        }
        console.log('写入成功');
    })
});

/*
window.localStorage的内容
	inited:
	student:{
		add:[
			{id:studentID,...}
		]
		delete:[ {id:studentID, studentID: studentID} ]
		update:[
			[id:studentID,...]
		]
	}
	teacher:{
		add:[
			{...}
		]
		delete:[ {id:teacherID, teacherID: teacherID} ]
		update:[
			{id:teacherID,...}
		]
	}
	course:{
		add:[
			{id:teacherID,...}
		]
		delete:[ {id:courseID, courseID: courseID} ]
		update:[
			{id:teacherID,...}
		]
	}
	grade:{
		add:[
			{id:courseID+studentID,...}
		]
		delete:[ {id:courseID+studentID (字符串相加）,courseID: courseID, studentID: studentID} ]
		update:[
			{id:courseID+studentID,...}
		]
	}
*/

function Stor() {
	this.get = function(string) {
		return JSON.parse(window.localStorage[string]);
	};
	this.set = function(string, dict) {
		window.localStorage[string] = JSON.stringify(dict);
	}
	this.init = function() {
		if (window.localStorage["init"] != null)
			return;
		window.localStorage["init"] = "1";
		function _() {
			return JSON.stringify({
				"add":[],
				"delete":[],
				"update":[]
			})
		}
		window.localStorage["student"] = _();
		window.localStorage["teacher"] = _();
		window.localStorage["course"] = _();
		window.localStorage["grade"] = _();
	};
	this.notEmpty = function() {
		for (var key in this.get("student")) {
			if (this.get("student")[key].length != 0) {
				return true;
			}
		}
		for (var key in this.get("teacher")) {
			if (this.get("teacher")[key].length != 0) {
				return true;
			}
		}
		for (var key in this.get("course")) {
			if (this.get("course")[key].length != 0) {
				return true;
			}
		}
		for (var key in this.get("grade")) {
			if (this.get("grade")[key].length != 0) {
				return true;
			}
		}
		return false;
	}
	this.del = function(opt, target, index) {
		//index为要删除的索引
		//opt为add, delete, update
		var temp = this.get(target);
		//var index = getIndex(temp[opt], object);
		temp[opt].splice(index, 1);
		this.set(target, temp);
	}
	this.put = function(opt, target, dict) {
		//object为要添加的数据
		//opt为add, delete, update
		//先判断是否存在，若存在则覆盖，不存在则添加
		function getIndex(arr, tar) {
			//根据id来确定是否是对同一个dict的更改,id为字符串
			for (var i in arr)
				if (arr[i]["id"] == tar["id"])
					return i;
			return -1;
		}
		var temp = this.get(target);
		var index = getIndex(temp[opt], dict);
		if (index != -1)
			this.del(opt, target, index); //若存在，则删除后添加
		temp = this.get(target);
		temp[opt].push(dict);
		this.set(target, temp);
		
	}
	this.show = function() {
		console.log(window.localStorage["init"]);
		console.log(window.localStorage["student"]);
		console.log(window.localStorage["grade"]);
		console.log(window.localStorage["teacher"]);
		console.log(window.localStorage["course"]);
	}
	//初始化localStorage
	this.init();
}
var stor = new Stor();


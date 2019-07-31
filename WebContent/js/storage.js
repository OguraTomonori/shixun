/*
window.localStorage的内容
	init:
	student:{
		add:[
				{
				ori:{}
				after:{}(null)
			}
		]
		delete:[ 
			{
				ori:{}
				after:{}(null)
			}
		]
		update:[
			{
				ori:{}
				after:{}
			}
		]
	}
	teacher:{
		add:[
				{
				ori:{}
				after:{}(null)
			}
		]
		delete:[ 
			{
				ori:{}
				after:{}(null)
			}
		]
		update:[
			{
				ori:{}
				after:{}
			}
		]
	}
	course:{
		add:[
				{
				ori:{}
				after:{}(null)
			}
		]
		delete:[ 
			{
				ori:{}
				after:{}(null)
			}
		]
		update:[
			{
				ori:{}
				after:{}
			}
		]
	}
	grade:{
		add:[
				{
				ori:{}
				after:{}(null)
			}
		]
		delete:[ 
			{
				ori:{}
				after:{}(null)
			}
		]
		update:[
			{
				ori:{}
				after:{}
			}
		]
	}
	selectCourse:{
		add:[
				{
				ori:{}
				after:{}(null)
			}
		]
		delete:[ 
			{
				ori:{}
				after:{}(null)
			}
		]
		update:[
			{
				ori:{}
				after:{}
			}
		]
	}
*/

function Stor() {
	this.get = function(target) {
		return JSON.parse(window.localStorage[target]);
	};
	this.set = function(target, dict) {
		window.localStorage[target] = JSON.stringify(dict);
	}
	this.clear = function() {
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
		window.localStorage["selectCourse"] = _();
	}
	this.init = function() {
		if (window.localStorage["init"] != null)
			return;
		window.localStorage["init"] = "1";
		this.clear();
	};
	this.getNum = function(target, opt) {
		var temp = this.get(target);
		temp = temp[opt];
		return temp.length;
	}
	this.getTargetNum = function(target) {
		//标识各修改种类数量
		return [this.getNum(target, "add"), this.getNum(target, "delete"), this.getNum(target, "update")];
	}
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
		for (var key in this.get("selectCourse")) {
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
	function getIndex(dictArr, ori) {
		//dictArr为[ {"ori":...,"after":...} ]
		//tar为 ori
		//通过判断ori来判断是否是同一条更改
		function equal(dictA, dictB) {
			for (var key in dictA) {
				if (!dictB[key] || (dictA[key] != dictB[key]))
					return false;
			}
			return true;
				
		}
		for (var i in dictArr) {
			if (equal(dictArr[i]["ori"], ori))
				return i;
			console.log(JSON.stringify(dictArr[i]["ori"]));
			console.log(JSON.stringify(ori));
		}
		
		
		return -1;
	}
	this.put = function(target, opt, ori, after) {
		//target为teacher，student ...
		//object为要添加的数据
		//opt为add, delete, update
		//ori, after为修改前后数据
		//先通过判断是否存在，若存在则覆盖，不存在则添加
		
		var temp = this.get(target); 
		var index = getIndex(temp[opt], ori);
		console.log(index);
		if (index != -1) 
			this.del(opt, target, index); //若存在，则删除后添加
		temp = this.get(target);
		temp[opt].push({
			"ori": ori,
			"after": after
		});
		this.set(target, temp);
	}
	this.delItem = function(target, ori) {
		//dictArr为[ {"ori":...,"after":...} ]
			//tar为 ori
			//通过判断ori来判断是否是同一条更改
		function temp(opt, target, index) {
			var index = -1;
			for (var i in target[opt])
				if (dictArr[i]["ori"] == ori)
					index = i;
			var temp = this.get(target); 
			if (index != -1)
				this.del(opt, target, index); 
		}
		temp("add", target, ori);
		temp("update", target, ori);
		temp("delete", target, ori);
	}
	this.show = function() {
		console.log(window.localStorage["init"]);
		console.log(window.localStorage["student"]);
		console.log(window.localStorage["grade"]);
		console.log(window.localStorage["teacher"]);
		console.log(window.localStorage["course"]);
		console.log(window.localStorage["selectCourse"]);
	}
	//初始化localStorage
	this.init();
}
var stor = new Stor();


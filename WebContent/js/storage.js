/*
window.localStorage的内容
	student:{
		add:[
			[...]
		]
		delete:[studentID],
		update:[
			[...]
		]
	}
	teacher:{
		add:[
			[...]
		]
		delete:[teacherID]
		update:[
			[...]
		]
	}
	course:{
		add:[
			[...]
		]
		delete:[courseID]
		update:[
			[...]
		]
	}
*/

function Stor() {

	this.add = function(string, dict) {
		window.localStorage[string] = JSON.stringify(dict);
	};
	this.get = function(string) {
		return JSON.parse(window.localStorage.getItem[string]);
	};
	this.delete = function(string) {
		window.localStorage.removeItem(string);
	};
	this.clear = function() {
		window.localStorage.clear();
	}
	this.getAddOption
}
var stor = new Stor();
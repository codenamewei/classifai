!function(){function t(t,e){return function(t){if(Array.isArray(t))return t}(t)||function(t,e){if("undefined"==typeof Symbol||!(Symbol.iterator in Object(t)))return;var n=[],o=!0,i=!1,r=void 0;try{for(var a,c=t[Symbol.iterator]();!(o=(a=c.next()).done)&&(n.push(a.value),!e||n.length!==e);o=!0);}catch(s){i=!0,r=s}finally{try{o||null==c.return||c.return()}finally{if(i)throw r}}return n}(t,e)||n(t,e)||function(){throw new TypeError("Invalid attempt to destructure non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}()}function e(t){return function(t){if(Array.isArray(t))return o(t)}(t)||function(t){if("undefined"!=typeof Symbol&&Symbol.iterator in Object(t))return Array.from(t)}(t)||n(t)||function(){throw new TypeError("Invalid attempt to spread non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}()}function n(t,e){if(t){if("string"==typeof t)return o(t,e);var n=Object.prototype.toString.call(t).slice(8,-1);return"Object"===n&&t.constructor&&(n=t.constructor.name),"Map"===n||"Set"===n?Array.from(t):"Arguments"===n||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)?o(t,e):void 0}}function o(t,e){(null==e||e>t.length)&&(e=t.length);for(var n=0,o=new Array(e);n<e;n++)o[n]=t[n];return o}function i(t,e){if(!(t instanceof e))throw new TypeError("Cannot call a class as a function")}function r(t,e){for(var n=0;n<e.length;n++){var o=e[n];o.enumerable=o.enumerable||!1,o.configurable=!0,"value"in o&&(o.writable=!0),Object.defineProperty(t,o.key,o)}}function a(t,e,n){return e&&r(t.prototype,e),n&&r(t,n),t}(window.webpackJsonp=window.webpackJsonp||[]).push([[7],{RN8A:function(n,o,r){"use strict";r.r(o),r.d(o,"DataSetLayoutModule",function(){return dt});var c=r("ofXK"),s=r("XIp8"),l=r("SxV6"),d=r("5+tZ"),b=r("lJxs"),u=r("/uUt"),p=r("1G5W"),g=r("XNiG"),f=r("cp0P"),h=r("HDdC"),v=r("3N8a"),m=new(r("IjjT").a)(v.a),j=r("DH7j");function w(){var t,e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:0,n=arguments.length>1&&void 0!==arguments[1]?arguments[1]:m;return t=e,(Object(j.a)(t)||!(t-parseFloat(t)+1>=0)||e<0)&&(e=0),n&&"function"==typeof n.schedule||(n=m),new h.a(function(t){return t.add(n.schedule(_,e,{subscriber:t,counter:0,period:e})),t})}function _(t){var e=t.subscriber,n=t.counter,o=t.period;e.next(n),this.schedule({subscriber:e,counter:n+1,period:o},o)}var M=r("z6cu"),x=r("3Pt+"),O=r("fXoL"),y=r("tyNb"),P=r("LY9J"),C=r("F7l1"),L=r("14na"),k=r("x2Se");function S(t,e){if(1&t){var n=O.Nb();O.Kb(0),O.Mb(1,"div",5),O.Mb(2,"div",6),O.Tb("click",function(){return O.gc(n),O.Vb(2).displayModal()}),O.Ib(3,"img",7),O.Mb(4,"label",8),O.lc(5),O.Lb(),O.Lb(),O.Lb(),O.Jb()}if(2&t){var o=O.Vb(),i=o.index,r=o.$implicit;O.xb(1),O.yb("data-index",i),O.xb(2),O.ac("src",r.src,O.hc),O.xb(2),O.mc(r.name)}}function I(t,e){if(1&t&&(O.Mb(0,"div",9),O.Ib(1,"img",10),O.Mb(2,"label",11),O.lc(3),O.Lb(),O.Lb()),2&t){var n=O.Vb(),o=n.$implicit;O.yb("data-index",n.index),O.xb(1),O.ac("src",o.src,O.hc),O.xb(2),O.mc(o.name)}}function N(t,e){if(1&t&&(O.Kb(0),O.jc(1,S,6,3,"ng-container",3),O.jc(2,I,4,3,"ng-template",null,4,O.kc),O.Jb()),2&t){var n=e.index,o=O.ec(3);O.xb(1),O.ac("ngIf",0===n)("ngIfElse",o)}}var T,U,E=((U=function(){function t(){var e=this;i(this,t),this.menuSchema=[{src:"../../../assets/icons/add.svg",name:"New Project"},{src:"../../../assets/icons/project.svg",name:"My Project"},{src:"../../../assets/icons/starred.svg",name:"Starred"},{src:"../../../assets/icons/history.svg",name:"Recent"},{src:"../../../assets/icons/trash.svg",name:"Trash"}],this._onClick=new O.n,this.displayModal=function(){e._onClick.emit(!0)}}return a(t,[{key:"ngOnInit",value:function(){}}]),t}()).\u0275fac=function(t){return new(t||U)},U.\u0275cmp=O.Bb({type:U,selectors:[["data-set-side-menu"]],outputs:{_onClick:"_onClick"},decls:3,vars:1,consts:[[1,"dataset-sidemenu-container"],[4,"ngFor","ngForOf"],[1,"horizontal-line"],[4,"ngIf","ngIfElse"],["otherMenu",""],[1,"new-project-container"],[1,"new-project-btn",3,"click"],[1,"add-icon",3,"src"],[1,"new-project-txt"],[1,"current-project-btn"],[1,"project-icon",3,"src"],[1,"current-project-txt"]],template:function(t,e){1&t&&(O.Mb(0,"div",0),O.jc(1,N,4,2,"ng-container",1),O.Lb(),O.Ib(2,"div",2)),2&t&&(O.xb(1),O.ac("ngForOf",e.menuSchema))},directives:[c.j,c.k],styles:[".dataset-sidemenu-container[_ngcontent-%COMP%]{display:flex;flex-wrap:wrap;flex-direction:column;width:16vw}.new-project-container[_ngcontent-%COMP%]{margin-bottom:5vh;margin-left:2vw}.new-project-btn[_ngcontent-%COMP%]{padding:1vw;border-radius:5vh;background-color:#525353;border:none;color:#fff;outline:none;cursor:pointer;display:flex;justify-content:space-around;align-items:center;min-width:10vw;max-width:10vw;min-height:4vh;max-height:4vh}.new-project-btn[_ngcontent-%COMP%]:hover{background-color:#393838}.add-icon[_ngcontent-%COMP%]{min-height:inherit;max-height:inherit}.new-project-txt[_ngcontent-%COMP%]{border:none;background:none;outline:none;cursor:pointer;font-size:2vh;color:#fff;text-align:start;white-space:nowrap}.current-project-btn[_ngcontent-%COMP%]{color:#fff;cursor:pointer;display:flex;align-items:center;border-radius:5vh;padding:1vh 1vw;margin-left:2vw;min-width:10vw;max-width:10vw;min-height:5vh;max-height:5vh;flex:1 1 100%}.current-project-btn[_ngcontent-%COMP%]:hover{background-color:#525353}.project-icon[_ngcontent-%COMP%]{min-height:4vh;max-height:4vh;flex:1 1 10%}.current-project-txt[_ngcontent-%COMP%]{border:none;background:none;outline:none;cursor:pointer;font-size:2vh;color:#fff;white-space:nowrap;flex:1 1 90%;text-align:center}.horizontal-line[_ngcontent-%COMP%]{width:12vw;background-color:#393838;min-height:.3vh;max-height:.3vh;margin:auto;border:.0625rem solid #000}"]}),U),z=((T=function(){function t(){i(this,t)}return a(t,[{key:"ngOnInit",value:function(){}}]),t}()).\u0275fac=function(t){return new(t||T)},T.\u0275cmp=O.Bb({type:T,selectors:[["data-set-header"]],decls:5,vars:0,consts:[[1,"dataset-header-container"],[1,"label"],[1,"dataset-icon-container"]],template:function(t,e){1&t&&(O.Mb(0,"div",0),O.Mb(1,"label",1),O.lc(2,"Dataset Management"),O.Lb(),O.Mb(3,"div",2),O.Ib(4,"div"),O.Lb(),O.Lb())},styles:[".dataset-header-container[_ngcontent-%COMP%]{display:flex;justify-content:space-around;align-items:center;padding:1vw;min-width:80vw;max-width:80vw}.label[_ngcontent-%COMP%]{flex:1 1 80%;background:none;font-size:2vh;color:#fff;white-space:nowrap;min-height:inherit;max-height:inherit}.dataset-icon-container[_ngcontent-%COMP%]{display:flex;justify-content:space-between;align-items:center;flex:1 1 20%}.dataset-icon[_ngcontent-%COMP%]{flex:1 1 3%;min-width:2vw;max-width:2vw;cursor:pointer}.dataset-icon[_ngcontent-%COMP%]:hover{border-radius:5vh;background-color:#393838}.dataset-select[_ngcontent-%COMP%]{min-height:4vh;max-height:4vh;font-size:2vh;min-width:7vw;max-width:7vw;-moz-text-align-last:center;background:#000;color:#fff;border:.1vw solid;text-align-last:center}.dataset-select[_ngcontent-%COMP%]:focus, .dataset-select[_ngcontent-%COMP%]:hover{background:#393838}.dataset-select[_ngcontent-%COMP%]:focus, .dataset-select[_ngcontent-%COMP%]:hover, select[_ngcontent-%COMP%]{-moz-appearance:none;-webkit-appearance:none}option[_ngcontent-%COMP%]{background:#000;text-align:center}"]}),T);function F(t,e){1&t&&(O.Kb(0),O.Mb(1,"div",2),O.Mb(2,"div",3),O.Mb(3,"div",4),O.Mb(4,"label",5),O.lc(5,"Fetching your project..."),O.Lb(),O.Lb(),O.Mb(6,"div"),O.Mb(7,"label",6),O.lc(8,"Please wait... while we prepare the dishes"),O.Lb(),O.Lb(),O.Lb(),O.Lb(),O.Jb())}function D(t,e){1&t&&(O.Kb(0),O.Mb(1,"label",22),O.lc(2," Uploading "),O.Lb(),O.Jb())}function A(t,e){1&t&&(O.Kb(0),O.Mb(1,"label",24),O.lc(2,"New"),O.Lb(),O.Jb())}function J(t,e){1&t&&(O.Kb(0),O.Mb(1,"label",25),O.lc(2,"Available"),O.Lb(),O.Jb())}function $(t,e){1&t&&(O.Kb(0),O.Mb(1,"label",26),O.lc(2,"Not Available"),O.Lb(),O.Jb())}function V(t,e){if(1&t&&(O.Kb(0,23),O.jc(1,A,3,0,"ng-container",16),O.jc(2,J,3,0,"ng-container",16),O.jc(3,$,3,0,"ng-container",16),O.Jb()),2&t){var n=O.Vb().$implicit;O.ac("ngSwitch",n),O.xb(1),O.ac("ngIf",n.is_new),O.xb(1),O.ac("ngIf",!n.is_new&&!n.is_loaded),O.xb(1),O.ac("ngIf",!n.is_new&&n.is_loaded)}}function K(t,e){if(1&t){var n=O.Nb();O.Kb(0),O.Mb(1,"span"),O.Mb(2,"div",27),O.Mb(3,"div",28),O.Tb("click",function(){O.gc(n);var t=O.Vb(),e=t.index,o=t.$implicit;return O.Vb(3).onUploadContent(e,o.project_name)}),O.lc(4," Upload Folder "),O.Lb(),O.Mb(5,"div",28),O.Tb("click",function(){O.gc(n);var t=O.Vb(),e=t.index,o=t.$implicit;return O.Vb(3).onUploadContent(e,o.project_name,"file")}),O.lc(6," Upload Photo(s) "),O.Lb(),O.Lb(),O.Lb(),O.Jb()}}var H=function(t){return[t]};function B(t,e){if(1&t){var n=O.Nb();O.Kb(0),O.Mb(1,"div",9),O.Tb("dblclick",function(){O.gc(n);var t=e.index,o=e.$implicit;return O.Vb(3).onOpenProject(t,o)}),O.Mb(2,"div",10),O.Mb(3,"div"),O.jc(4,D,3,0,"ng-container",0),O.jc(5,V,4,4,"ng-template",null,11,O.kc),O.Lb(),O.Mb(7,"div",12),O.Mb(8,"div",13),O.Tb("click",function(){O.gc(n);var t=e.$implicit,o=O.Vb(3);return o.conditionalDisableClickEvent(t.is_loaded)?null:o.onStarred(t,!t.is_starred)}),O.Ib(9,"img",14),O.Lb(),O.Mb(10,"div",13),O.Tb("click",function(){O.gc(n);var t=e.$implicit,o=e.index,i=O.Vb(3);return i.conditionalDisableClickEvent(t.is_loaded)?null:i.onDisplayMore(o)}),O.Ib(11,"img",15),O.Lb(),O.jc(12,K,7,0,"ng-container",16),O.Lb(),O.Lb(),O.Mb(13,"div",17),O.Mb(14,"label",18),O.Mb(15,"div",19),O.lc(16),O.Lb(),O.Lb(),O.Lb(),O.Mb(17,"div",20),O.Mb(18,"label",18),O.Mb(19,"div",21),O.lc(20),O.Lb(),O.Lb(),O.Lb(),O.Mb(21,"div",20),O.Mb(22,"label",18),O.Mb(23,"div",21),O.lc(24),O.Lb(),O.Lb(),O.Lb(),O.Lb(),O.Jb()}if(2&t){var o=e.$implicit,i=e.index,r=O.ec(6),a=O.Vb(3);O.xb(1),O.ac("ngClass",a.conditionalDisableProject(o)),O.yb("data-index",i),O.xb(3),O.ac("ngIf",a.isExactIndex(i)&&a._jsonSchema.isUploading)("ngIfElse",r),O.xb(3),O.ac("ngClass",a.conditionalDisableProject(o)),O.xb(2),O.ac("src",O.cc(13,H,o.is_starred?a.starredActiveIcon:a.starredInactiveIcon),O.hc),O.xb(3),O.ac("ngIf",a.isExactIndex(i)),O.xb(2),O.ac("title",o.created_date),O.xb(2),O.nc("Created: ",o.created_date,""),O.xb(2),O.ac("title",o.project_name),O.xb(2),O.nc(" ",o.project_name," "),O.xb(2),O.ac("title","Total Photo: "+o.total_uuid),O.xb(2),O.nc("Total Photo: ",o.total_uuid,"")}}function G(t,e){if(1&t&&(O.Kb(0),O.Mb(1,"div",2),O.jc(2,B,25,15,"ng-container",8),O.Lb(),O.Jb()),2&t){var n=O.Vb(2);O.xb(2),O.ac("ngForOf",n._jsonSchema.projects)}}function X(t,e){1&t&&(O.Mb(0,"div",2),O.Mb(1,"div",3),O.Mb(2,"div",4),O.Mb(3,"label",5),O.lc(4,"Wait a minute... there's no project"),O.Lb(),O.Lb(),O.Mb(5,"div"),O.Mb(6,"label",6),O.lc(7,"Gear up and start creating new project!"),O.Lb(),O.Lb(),O.Lb(),O.Lb())}function q(t,e){if(1&t&&(O.jc(0,G,3,1,"ng-container",0),O.jc(1,X,8,0,"ng-template",null,7,O.kc)),2&t){var n=O.ec(2),o=O.Vb();O.ac("ngIf",o._jsonSchema.projects.length>0)("ngIfElse",n)}}var Y,R=((Y=function(){function t(){var e=this;i(this,t),this._onClick=new O.n,this._onUpload=new O.n,this._onStarred=new O.n,this.starredActiveIcon="../../../assets/icons/starred_active.svg",this.starredInactiveIcon="../../../assets/icons/starred.svg",this.cardSchema={clickIndex:-1},this.conditionalDisableProject=function(t){return t.is_loaded?"disabled":"enabled"},this.conditionalDisableClickEvent=function(t){return t},this.onOpenProject=function(t,n){var o=n.project_name;!n.is_loaded&&!e.isExactIndex(t)&&e._onClick.emit(o)},this.onUploadContent=function(t,n,o){e.cardSchema={clickIndex:t},e._onUpload.emit({projectName:n,fileType:null!=o?o:"folder"})},this.onDisplayMore=function(){var t=arguments.length>0&&void 0!==arguments[0]?arguments[0]:e.cardSchema.clickIndex,n=e.cardSchema.clickIndex;e.cardSchema={clickIndex:n===t?-1:t}},this.onStarred=function(t,n){var o=t.project_name;e._jsonSchema.projects=e._jsonSchema.projects.map(function(t){return t.project_name===o?(t.is_starred=n,t):t}),e._onStarred.emit({projectName:o,starred:n})},this.isExactIndex=function(t){return t===e.cardSchema.clickIndex}}return a(t,[{key:"ngOnInit",value:function(){}},{key:"ngOnChanges",value:function(t){!t._jsonSchema.currentValue.isUploading&&this.onDisplayMore()}}]),t}()).\u0275fac=function(t){return new(t||Y)},Y.\u0275cmp=O.Bb({type:Y,selectors:[["data-set-card"]],inputs:{_jsonSchema:"_jsonSchema"},outputs:{_onClick:"_onClick",_onUpload:"_onUpload",_onStarred:"_onStarred"},features:[O.vb],decls:3,vars:2,consts:[[4,"ngIf","ngIfElse"],["showCardBody",""],[1,"card-layout-container","scroll","fade-in"],[1,"no-project-card-container"],[1,"no-project-title-padding"],[1,"no-project-title"],[1,"no-project-subtitle"],["noProject",""],[4,"ngFor","ngForOf"],[1,"card-container",3,"ngClass","dblclick"],[1,"card-header-style"],["newLabel",""],[1,"card-icon-container",3,"ngClass"],[3,"click"],[1,"card-icon-style",3,"src"],["src","../../../assets/icons/more.svg",1,"card-icon-style"],[4,"ngIf"],[1,"card-title-style"],[3,"title"],[1,"card-title-txt"],[1,"project-name-style"],[1,"project-info"],[1,"project-status-uploading"],[3,"ngSwitch"],[1,"project-status-new"],[1,"project-status-available"],[1,"project-status-not-available"],[1,"popup-container"],[1,"popup-label",3,"click"]],template:function(t,e){if(1&t&&(O.jc(0,F,9,0,"ng-container",0),O.jc(1,q,3,2,"ng-template",null,1,O.kc)),2&t){var n=O.ec(2);O.ac("ngIf",e._jsonSchema.isFetching)("ngIfElse",n)}},directives:[c.k,c.j,c.i,c.m],styles:['@keyframes fadeIn{0%{opacity:0}to{opacity:1}}@-webkit-keyframes fadeIn{0%{opacity:0}to{opacity:1}}.fade-in[_ngcontent-%COMP%]{animation:fadeIn 1.5s ease;-webkit-animation:fadeIn 1.5s ease;-moz-animation:fadeIn ease 1.5s;-o-animation:fadeIn ease 1.5s;-ms-animation:fadeIn ease 1.5s}.card-layout-container[_ngcontent-%COMP%]{width:80vw;display:flex;flex-wrap:wrap;padding:0 0 0 1vw;overflow-y:scroll;position:relative;height:80vh}.scroll[_ngcontent-%COMP%]::-webkit-scrollbar-track{box-shadow:inset 0 0 6px rgba(0,0,0,.3);border-radius:10px;background-color:#000}.scroll[_ngcontent-%COMP%]::-webkit-scrollbar{width:.5vw}.scroll[_ngcontent-%COMP%]::-webkit-scrollbar-thumb{border-radius:10px;box-shadow:inset 0 0 6px rgba(0,0,0,.3);background-color:#525353}.card-container[_ngcontent-%COMP%]{min-width:11vw;max-width:11vw;min-height:30vh;max-height:30vh;border-style:solid;font-size:2.2vh;background:#2e2d2d;position:relative}.card-container[_ngcontent-%COMP%]:hover{background:#404040}.card-container[_ngcontent-%COMP%]:before{content:"";display:block;height:100%;position:absolute;top:0;left:0;width:.3vw;background-color:#363636}.enabled[_ngcontent-%COMP%]{cursor:pointer}.disabled[_ngcontent-%COMP%]{cursor:not-allowed}.project-status-new[_ngcontent-%COMP%]{background-color:#f59221}.project-status-available[_ngcontent-%COMP%], .project-status-new[_ngcontent-%COMP%]{color:#f5f5f5;font-size:1.5vh;padding:.3vh 1.5vw .6vh 1vw}.project-status-available[_ngcontent-%COMP%]{background-color:#4bf521}.project-status-not-available[_ngcontent-%COMP%]{background-color:#f52121}.project-status-not-available[_ngcontent-%COMP%], .project-status-uploading[_ngcontent-%COMP%]{color:#f5f5f5;font-size:1.5vh;padding:.3vh 1.5vw .6vh 1vw}.project-status-uploading[_ngcontent-%COMP%]{background-color:#f5219d}.card-icon-container[_ngcontent-%COMP%]{display:flex}.card-icon-style[_ngcontent-%COMP%]{min-width:1.5vw;max-width:1.5vw;min-height:3vh;max-height:3vh}.card-icon-style[_ngcontent-%COMP%]:hover{border-radius:5vh;background-color:#393838}.card-header-style[_ngcontent-%COMP%]{margin-top:1vh;display:flex;flex-direction:row;justify-content:space-between;position:relative}.card-title-style[_ngcontent-%COMP%]{margin-left:1vw}.card-title-txt[_ngcontent-%COMP%]{color:#656667;font-size:1.3vh;white-space:nowrap;overflow:hidden;text-overflow:ellipsis}.project-name-style[_ngcontent-%COMP%]{margin-left:1vw;padding:1vh 0 0}.project-info[_ngcontent-%COMP%]{color:#dbdbda;font-size:2vh;white-space:nowrap;overflow:hidden;text-overflow:ellipsis}.tag-container[_ngcontent-%COMP%]{display:flex;flex-direction:row;border-radius:10vw;background:#363636;width:4.5vw;padding:.2vw .3vh;cursor:pointer;outline:none;border:none;margin:.8vh 0 0 1vw}.tag-img[_ngcontent-%COMP%]{min-height:2vh;max-height:2vh;min-width:1vw;max-width:1vw;margin-left:.35vw}.tag-txt[_ngcontent-%COMP%]{font-size:1.2vh;color:#fff;padding:.2vh 0 0 .3vw;cursor:pointer}.popup-container[_ngcontent-%COMP%]{overflow:hidden;position:absolute;margin:4vh 0 0 -10vw;padding:.5vw;border-radius:.2vw;box-shadow:0 2px 5px 0 rgba(var(--shadow-rgb),.26),0 2px 10px 0 rgba(var(--shadow-rgb),.16);transform-origin:left top;transform:scale(1);opacity:1;white-space:nowrap;background:#fff;font-size:1.5vh;-webkit-animation:appear .35s ease-in 1;animation:appear .35s ease-in 1}@-webkit-keyframes appear{0%{opacity:0;transform:translateY(-10px)}}@keyframes appear{0%{opacity:0;transform:translateY(-10px)}}.popup-label[_ngcontent-%COMP%]{font-size:2vh;padding:.5vw}.popup-label[_ngcontent-%COMP%]:hover{background:#e9e9e9}.no-project-title[_ngcontent-%COMP%]{font-size:4vh;color:#000;white-space:nowrap}.no-project-title-padding[_ngcontent-%COMP%]{padding:2vw}.no-project-subtitle[_ngcontent-%COMP%]{font-size:2vh;color:#656667;white-space:nowrap}.no-project-card-container[_ngcontent-%COMP%]{display:flex;flex-direction:column;justify-content:center;align-items:center;background-color:#c8c6c6;width:100%}']}),Y);function Z(t,e){1&t&&(O.Kb(0),O.Mb(1,"div",1),O.Mb(2,"div",2),O.Mb(3,"div",3),O.Ib(4,"div",4),O.Ib(5,"div",4),O.Lb(),O.Mb(6,"div",5),O.Ib(7,"div",4),O.Ib(8,"div",4),O.Lb(),O.Lb(),O.Lb(),O.Jb())}var W,Q=((W=function(){function t(){i(this,t),this._loading=!0}return a(t,[{key:"ngOnInit",value:function(){}},{key:"ngOnChanges",value:function(t){}}]),t}()).\u0275fac=function(t){return new(t||W)},W.\u0275cmp=O.Bb({type:W,selectors:[["spinner"]],inputs:{_loading:"_loading"},features:[O.vb],decls:1,vars:1,consts:[[4,"ngIf"],[1,"mesh-loader-container"],[1,"mesh-loader"],[1,"set-one"],[1,"circle"],[1,"set-two"]],template:function(t,e){1&t&&O.jc(0,Z,9,0,"ng-container",0),2&t&&O.ac("ngIf",e._loading)},directives:[c.k],styles:[".mesh-loader-container[_ngcontent-%COMP%]{overflow:hidden;position:fixed;top:0;right:0;bottom:0;left:0;opacity:.85;z-index:10000;cursor:progress}.mesh-loader[_ngcontent-%COMP%]{overflow:hidden;height:100%;width:100%}.mesh-loader[_ngcontent-%COMP%]   .circle[_ngcontent-%COMP%]{width:1.6276041667vw;height:3.3156498674vh;position:absolute;background:#03a9f4;border-radius:50%;margin:-.8138020833vw;-webkit-animation:mesh 3s ease-in-out infinite;animation:mesh 3s ease-in-out -1.5s infinite}.mesh-loader[_ngcontent-%COMP%] > div[_ngcontent-%COMP%]   .circle[_ngcontent-%COMP%]:last-child{-webkit-animation-delay:0s;animation-delay:0s}.mesh-loader[_ngcontent-%COMP%] > div[_ngcontent-%COMP%]{position:absolute;top:50%;left:50%}.mesh-loader[_ngcontent-%COMP%] > div[_ngcontent-%COMP%]:last-child{transform:rotate(90deg)}@-webkit-keyframes mesh{0%{transform-origin:50% -100%;transform:rotate(0)}50%{transform-origin:50% -100%;transform:rotate(1turn)}50.00001%{transform-origin:50% 200%;transform:rotate(0deg)}to{transform-origin:50% 200%;transform:rotate(1turn)}}@keyframes mesh{0%{transform-origin:50% -100%;transform:rotate(0)}50%{transform-origin:50% -100%;transform:rotate(1turn)}50.00001%{transform-origin:50% 200%;transform:rotate(0deg)}to{transform-origin:50% 200%;transform:rotate(1turn)}}"]}),W),tt=["refProjectName"];function et(t,e){1&t&&(O.Mb(0,"span"),O.Mb(1,"small",23),O.lc(2," * Project name already exist! Try other name "),O.Lb(),O.Lb())}function nt(t,e){1&t&&(O.Mb(0,"span"),O.Mb(1,"small",23),O.lc(2," * Project name is required "),O.Lb(),O.Lb())}function ot(t,e){if(1&t&&(O.Kb(0),O.Mb(1,"div",22),O.jc(2,et,3,0,"span",14),O.jc(3,nt,3,0,"span",14),O.Lb(),O.Jb()),2&t){var n=O.Vb(),o=null,i=null;O.xb(2),O.ac("ngIf",null==(o=n.form.get("projectName"))?null:o.getError("exist")),O.xb(1),O.ac("ngIf",null==(i=n.form.get("projectName"))?null:i.getError("required"))}}var it,rt,at,ct=[{path:"",component:(it=function(){function n(o,r,a,c,h,v){var m=this;i(this,n),this._fb=o,this._cd=r,this._router=a,this._dataSetService=c,this._spinnerService=h,this._imgLblModeService=v,this.onChangeSchema={currentThumbnailIndex:-1,thumbnailName:"",totalNumThumbnail:0,status:void 0},this.projectList={projects:[],isUploading:!1,isFetching:!1},this.inputProjectName="",this.selectedProjectName="",this.labelTextUpload=[],this.displayModal=!1,this.subject$=new g.a,this.thumbnailList=[],this.labelList=[],this.unsubscribe$=new g.a,this.isLoading=!1,this.imgLblMode=null,this.getProjectList=function(){m.projectList.isFetching=!0,m._dataSetService.getProjectList().pipe(Object(l.a)()).subscribe(function(t){var n=t.content;if(n){var o=Object(s.a)(n).map(function(t){return Object.assign(Object.assign({},t),{created_date:m.formatDate(t.created_date)})});m.projectList.projects=e(o),m.projectList.isFetching=!1}})},this.formatDate=function(t){var e=new Date(t),n=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"].find(function(t,n){return n===e.getMonth()||void 0});return n?"".concat(n,"-").concat(e.getDate(),"-").concat(e.getFullYear()):"Error"},this.createFormControls=function(){m.form=m._fb.group({projectName:["",x.j.required]})},this.onChange=function(t){m.inputProjectName=t},this.toggleModalDisplay=function(t){t&&m.form.reset(),m.displayModal=t,setTimeout(function(){return m._refProjectName.nativeElement.focus()})},this.onFileChange=function(t){var n=t.target.files,o=new FileReader;if(n&&n.length){var i=n.item(0);o.onload=function(){m._cd.markForCheck()},o.onloadend=function(){var t=o.result.split("\n");if(t.length>0){var n,i=t.reduce(function(t,e){var n=e.replace(/[^A-Z0-9]+/gi,"").toLowerCase();return t.push(n),t},[]);m.labelTextUpload=[],(n=m.labelTextUpload).push.apply(n,e(i))}},i&&o.readAsText(i)}},this.onStarred=function(t){var e=t.projectName,n=t.starred;m._dataSetService.updateProjectStatus(e,n,"star").pipe(Object(l.a)()).subscribe(function(t){var e=t.message;return console.log(e)},function(t){return m.projectList={isUploading:m.projectList.isUploading,isFetching:m.projectList.isFetching,projects:m.projectList.projects.map(function(t){return t.project_name===e?Object.assign(Object.assign({},t),{is_starred:!1}):t})}})},this.onSubmit=function(t,e){var n,o,i;m.form.markAllAsTouched(),t?m.inputProjectName?m.projectList.projects&&m.projectList.projects.find(function(t){return t?t.project_name===m.inputProjectName:null})?(null===(n=m.form.get("projectName"))||void 0===n||n.setErrors({exist:!0}),m._refProjectName.nativeElement.focus()):(m.createProject(m.inputProjectName),m.selectedProjectName=null===(o=m.form.get("projectName"))||void 0===o?void 0:o.value):(null===(i=m.form.get("projectName"))||void 0===i||i.setErrors({required:!0}),m._refProjectName.nativeElement.focus()):e&&m.startProject(e)},this.startProject=function(n){m.selectedProjectName=n;var o=m._dataSetService.checkProjectStatus(n),i=m._dataSetService.updateProjectLoadStatus(n),r=m._dataSetService.checkExistProjectStatus(n),a=m._dataSetService.getThumbnailList;m.subjectSubscription=m.subject$.pipe(Object(d.a)(function(){return Object(f.a)([o])}),Object(l.a)(function(e){var n=t(e,1)[0],o=n.message,i=n.content;m.projectList={isUploading:m.projectList.isUploading,isFetching:m.projectList.isFetching,projects:m.projectList.projects.map(function(t){return t.project_name===i[0].project_name?Object.assign(Object.assign({},i[0]),{created_date:t.created_date}):t})};var r=i[0].is_loaded;return 1===o&&!r}),Object(d.a)(function(e){return t(e,1)[0].message?Object(f.a)([i,r]):[]}),Object(d.a)(function(o){var i=t(o,2);!function(t){if(null==t)throw new TypeError("Cannot destructure undefined")}(i[0]);var c=i[1],s=c.message,b=c.uuid_list,u=c.label_list;return 2===s?(m.labelList=e(u),b.length>0?b.map(function(t){return a(n,t)}):[]):w(500).pipe(Object(d.a)(function(){return r}),Object(l.a)(function(t){return 2===t.message}),Object(d.a)(function(t){var o=t.uuid_list,i=t.label_list;return m.labelList=e(i),o.length>0?o.map(function(t){return a(n,t)}):[]}))}),Object(d.a)(function(t){return t})).subscribe(function(t){m.thumbnailList=[].concat(e(m.thumbnailList),[t])},function(t){},function(){m._router.navigate(["imglabel/"+m.imgLblMode],{state:{thumbnailList:m.thumbnailList,projectName:n,labelList:m.labelList}}),m._spinnerService.hideSpinner()}),m.subject$.next()},this.uploadThumbnail=function(t){var e=t.projectName,n=void 0===e?m.inputProjectName:e,o=t.fileType,i=m._dataSetService.localUploadThumbnail(n,o),r=m._dataSetService.localUploadStatus(n),a=m._dataSetService.getThumbnailList,c=0;m.projectList=Object.assign(Object.assign({},m.projectList),{isUploading:!0}),m.subjectSubscription=m.subject$.pipe(Object(l.a)(),Object(d.a)(function(){return i}),Object(d.a)(function(t){return 5!==(e=t.message)&&1===e?w(500).pipe(Object(d.a)(function(){return r}),Object(l.a)(function(t){var e=t.message;return 4===e||1===e}),Object(d.a)(function(t){var e=t.uuid_list,o=4===t.message&&e.length>0?e.map(function(t){return a(n,t)}):[];return m.projectList=Object.assign(Object.assign({},m.projectList),o.length>0?{isUploading:!0}:{isUploading:!1}),c=o.length,o}),Object(d.a)(function(t){return t})):Object(M.a)(function(t){return console.error(t),m.projectList=Object.assign(Object.assign({},m.projectList),{isUploading:!1}),t});var e})).subscribe(function(t){(c=t?--c:c)<1&&(m.projectList=Object.assign(Object.assign({},m.projectList),{isUploading:!1}))},function(t){},function(){m.getProjectList()}),m.subject$.next()},this.createProject=function(t){var e=m._dataSetService.createNewProject(t),n=m._dataSetService.updateLabelList(t,m.labelTextUpload);e.pipe(Object(l.a)(),Object(b.a)(function(t){return t.message}),Object(d.a)(function(){return n})).subscribe(function(t){1===t.message&&(m.getProjectList(),m.toggleModalDisplay(!1))})},this.keyDownEvent=function(t){"Escape"===t.key&&m.displayModal&&m.toggleModalDisplay(!1)},this._imgLblModeService.imgLabelMode$.pipe(Object(u.a)()).subscribe(function(t){return m.imgLblMode=t}),this._spinnerService.returnAsObservable().pipe(Object(p.a)(this.unsubscribe$)).subscribe(function(t){return m.isLoading=t}),this.createFormControls()}return a(n,[{key:"ngOnInit",value:function(){this.getProjectList()}},{key:"ngOnDestroy",value:function(){this.unsubscribe$.next(),this.unsubscribe$.complete()}}]),n}(),it.\u0275fac=function(t){return new(t||it)(O.Hb(x.b),O.Hb(O.h),O.Hb(y.a),O.Hb(P.a),O.Hb(C.a),O.Hb(L.a))},it.\u0275cmp=O.Bb({type:it,selectors:[["data-set-layout"]],viewQuery:function(t,e){var n;1&t&&O.pc(tt,!0),2&t&&O.dc(n=O.Ub())&&(e._refProjectName=n.first)},hostBindings:function(t,e){1&t&&O.Tb("keydown",function(t){return e.keyDownEvent(t)},!1,O.fc)},decls:30,vars:7,consts:[[3,"_onChange"],[1,"upper-container"],[3,"_onClick"],[3,"_jsonSchema","_onClick","_onStarred","_onUpload"],[3,"hidden"],[1,"model"],[3,"formGroup"],[1,"model-content"],[1,"content-container"],[1,"content-header"],[1,"new-project-container"],[1,"label"],["type","text","placeholder","Enter project name","formControlName","projectName",1,"input-style",3,"value","input"],["refProjectName",""],[4,"ngIf"],[1,"select-folder-container"],["type","file","accept",".txt",1,"input",3,"change"],[1,"horizontal-line"],[1,"model-button-container"],["type","submit",1,"button-style","create-btn",3,"click"],[1,"button-style","cancel-btn",3,"click"],[3,"_loading"],[1,"validation"],[1,"error-msg"]],template:function(t,e){var n;(1&t&&(O.Ib(0,"page-header",0),O.Mb(1,"div",1),O.Mb(2,"data-set-side-menu",2),O.Tb("_onClick",function(t){return e.toggleModalDisplay(t)}),O.Lb(),O.Mb(3,"div"),O.Ib(4,"data-set-header"),O.Mb(5,"data-set-card",3),O.Tb("_onClick",function(t){return e.onSubmit(!1,t)})("_onStarred",function(t){return e.onStarred(t)})("_onUpload",function(t){return e.uploadThumbnail(t)}),O.Lb(),O.Lb(),O.Lb(),O.Mb(6,"div",4),O.Mb(7,"div",5),O.Mb(8,"form",6),O.Mb(9,"div",7),O.Mb(10,"div",8),O.Mb(11,"h1",9),O.lc(12,"Create new Project"),O.Lb(),O.Mb(13,"div",10),O.Mb(14,"label",11),O.lc(15,"New Project Name: "),O.Lb(),O.Mb(16,"input",12,13),O.Tb("input",function(t){return e.onChange(t.target.value)}),O.Lb(),O.Lb(),O.jc(18,ot,4,2,"ng-container",14),O.Mb(19,"div",15),O.Mb(20,"label",11),O.lc(21,"Label list file (*.txt): "),O.Lb(),O.Mb(22,"input",16),O.Tb("change",function(t){return e.onFileChange(t)}),O.Lb(),O.Lb(),O.Ib(23,"div",17),O.Mb(24,"div",18),O.Mb(25,"button",19),O.Tb("click",function(){return e.onSubmit(!0)}),O.lc(26,"Create"),O.Lb(),O.Mb(27,"button",20),O.Tb("click",function(){return e.toggleModalDisplay(!1)}),O.lc(28,"Cancel"),O.Lb(),O.Lb(),O.Lb(),O.Lb(),O.Lb(),O.Lb(),O.Lb(),O.Ib(29,"spinner",21)),2&t)&&(O.ac("_onChange",e.onChangeSchema),O.xb(5),O.ac("_jsonSchema",e.projectList),O.xb(1),O.ac("hidden",!e.displayModal),O.xb(2),O.ac("formGroup",e.form),O.xb(8),O.ac("value",e.inputProjectName),O.xb(2),O.ac("ngIf",null==(n=e.form.get("projectName"))?null:n.touched),O.xb(11),O.ac("_loading",e.isLoading))},directives:[k.a,E,z,R,x.l,x.g,x.d,x.a,x.f,x.c,c.k,Q],styles:[".upper-container[_ngcontent-%COMP%]{display:flex;margin-top:5vh}.model[_ngcontent-%COMP%]{z-index:1000;padding-top:10vh;top:0;width:100%;height:100%;overflow:auto;background-color:transparent;scrollbar-width:none;position:fixed;background:rgba(0,0,0,.7)}.model-content[_ngcontent-%COMP%]{background-color:#525353;padding:1vw;border:solid;max-width:30vw;min-width:30vw;border-radius:1vw;margin:15vh auto auto}.content-container[_ngcontent-%COMP%]{margin-left:1.3vw}.content-header[_ngcontent-%COMP%]{color:#fff;font-size:3vh}.new-project-container[_ngcontent-%COMP%]{display:flex;flex-direction:row;margin:3vh 0 0;align-items:baseline}.label[_ngcontent-%COMP%]{margin-right:1vw}.input-style[_ngcontent-%COMP%], .label[_ngcontent-%COMP%]{color:#fff;font-size:2vh}.input-style[_ngcontent-%COMP%]{border-radius:2vw;border:none;outline:none;background-color:#363636;min-width:11vw;max-width:11vw;min-height:4vh;max-height:4vh;padding:0 1vw}.validation[_ngcontent-%COMP%]{color:red}.error-msg[_ngcontent-%COMP%]{font-size:2vh}.select-folder-container[_ngcontent-%COMP%]{display:flex;flex-direction:row;margin:2vh 0 0}.input[_ngcontent-%COMP%]{color:#7fffd4}.horizontal-line[_ngcontent-%COMP%]{background-color:#fff;min-height:.3vh;max-height:.3vh;margin:2vh auto}.model-button-container[_ngcontent-%COMP%]{display:flex;flex-direction:row-reverse;padding:1vw}.button-style[_ngcontent-%COMP%]{padding:1vh 1.5vw;border-radius:1vh;border:none;outline:none;color:#fff;cursor:pointer;font-size:2vh}.create-btn[_ngcontent-%COMP%]{background-color:#169887}.cancel-btn[_ngcontent-%COMP%]{background-color:#444;margin-right:.7vw}"]}),it)}],st=((rt=function t(){i(this,t)}).\u0275mod=O.Fb({type:rt}),rt.\u0275inj=O.Eb({factory:function(t){return new(t||rt)},imports:[[y.d.forChild(ct)]]}),rt),lt=r("KZX/"),dt=((at=function t(){i(this,t)}).\u0275mod=O.Fb({type:at}),at.\u0275inj=O.Eb({factory:function(t){return new(t||at)},imports:[[c.b,lt.a,st]]}),at)}}])}();
!function(){function e(e){return function(e){if(Array.isArray(e))return o(e)}(e)||function(e){if("undefined"!=typeof Symbol&&Symbol.iterator in Object(e))return Array.from(e)}(e)||n(e)||function(){throw new TypeError("Invalid attempt to spread non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}()}function t(e,t){return function(e){if(Array.isArray(e))return e}(e)||function(e,t){if("undefined"==typeof Symbol||!(Symbol.iterator in Object(e)))return;var n=[],o=!0,a=!1,r=void 0;try{for(var i,c=e[Symbol.iterator]();!(o=(i=c.next()).done)&&(n.push(i.value),!t||n.length!==t);o=!0);}catch(s){a=!0,r=s}finally{try{o||null==c.return||c.return()}finally{if(a)throw r}}return n}(e,t)||n(e,t)||function(){throw new TypeError("Invalid attempt to destructure non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}()}function n(e,t){if(e){if("string"==typeof e)return o(e,t);var n=Object.prototype.toString.call(e).slice(8,-1);return"Object"===n&&e.constructor&&(n=e.constructor.name),"Map"===n||"Set"===n?Array.from(e):"Arguments"===n||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)?o(e,t):void 0}}function o(e,t){(null==t||t>e.length)&&(t=e.length);for(var n=0,o=new Array(t);n<t;n++)o[n]=e[n];return o}function a(e,t){if(!(e instanceof t))throw new TypeError("Cannot call a class as a function")}function r(e,t){for(var n=0;n<t.length;n++){var o=t[n];o.enumerable=o.enumerable||!1,o.configurable=!0,"value"in o&&(o.writable=!0),Object.defineProperty(e,o.key,o)}}function i(e,t,n){return t&&r(e.prototype,t),n&&r(e,n),e}(window.webpackJsonp=window.webpackJsonp||[]).push([[7],{RN8A:function(n,o,r){"use strict";r.r(o),r.d(o,"DataSetLayoutModule",function(){return pe});var c=r("ofXK"),s=r("XIp8"),l=r("SxV6"),b=r("lJxs"),d=r("eIep"),u=r("5+tZ"),m=r("/uUt"),p=r("1G5W"),f=r("XNiG"),g=r("l5mm"),h=r("cp0P"),v=r("z6cu"),j=r("3Pt+"),w=r("fXoL"),_=r("tyNb"),P=r("LY9J"),x=r("F7l1"),M=r("14na"),y=r("I7yr"),O=r("1F7/"),L=r("x2Se"),C=r("sYmb");function S(e,t){if(1&e){var n=w.Nb();w.Kb(0),w.Mb(1,"div",5),w.Mb(2,"div",6),w.Tb("click",function(){return w.hc(n),w.Vb(2).displayModal()}),w.Ib(3,"img",7),w.Mb(4,"label",8),w.oc(5),w.Wb(6,"translate"),w.Lb(),w.Lb(),w.Lb(),w.Jb()}if(2&e){var o=w.Vb(),a=o.index,r=o.$implicit;w.xb(1),w.yb("data-index",a),w.xb(2),w.ac("src",r.src,w.jc),w.xb(2),w.pc(w.Xb(6,3,r.name))}}function k(e,t){if(1&e){var n=w.Nb();w.Mb(0,"div",9),w.Tb("click",function(){w.hc(n);var e=w.Vb().$implicit;return w.Vb().onClickButton(e.id)}),w.Ib(1,"img",10),w.Mb(2,"label",11),w.oc(3),w.Wb(4,"translate"),w.Lb(),w.Lb()}if(2&e){var o=w.Vb(),a=o.$implicit;w.yb("data-index",o.index),w.xb(1),w.lc(a.style),w.ac("src",a.src,w.jc),w.xb(2),w.pc(w.Xb(4,5,a.name))}}function I(e,t){if(1&e&&(w.Kb(0),w.mc(1,S,7,5,"ng-container",3),w.mc(2,k,5,7,"ng-template",null,4,w.nc),w.Jb()),2&e){var n=t.index,o=w.fc(3);w.xb(1),w.ac("ngIf",0===n)("ngIfElse",o)}}var N,F,E=((F=function(){function e(){var t=this;a(this,e),this.menuSchema=[{src:"../../../assets/icons/add.svg",id:"newProject",name:"menuName.newProject"},{src:"../../../assets/icons/import.svg",id:"importProject",name:"menuName.importProject",style:"width: 1.3vw; padding: 0.3vw;"},{src:"../../../assets/icons/project.svg",id:"myProject",name:"menuName.myProject"},{src:"../../../assets/icons/starred.svg",id:"starred",name:"menuName.starred"},{src:"../../../assets/icons/history.svg",id:"recent",name:"menuName.recent"},{src:"../../../assets/icons/trash.svg",id:"trash",name:"menuName.trash"}],this._onCreate=new w.n,this._onImport=new w.n,this.displayModal=function(){t._onCreate.emit(!0)},this.onClickButton=function(e){"importProject"===e?t._onImport.emit():console.log("This feature is not available yet")}}return i(e,[{key:"ngOnInit",value:function(){}}]),e}()).\u0275fac=function(e){return new(e||F)},F.\u0275cmp=w.Bb({type:F,selectors:[["data-set-side-menu"]],outputs:{_onCreate:"_onCreate",_onImport:"_onImport"},decls:3,vars:1,consts:[[1,"dataset-sidemenu-container"],[4,"ngFor","ngForOf"],[1,"horizontal-line"],[4,"ngIf","ngIfElse"],["otherMenu",""],[1,"new-project-container"],[1,"new-project-btn",3,"click"],[1,"add-icon",3,"src"],[1,"new-project-txt"],[1,"current-project-btn",3,"click"],[1,"project-icon",3,"src"],[1,"current-project-txt"]],template:function(e,t){1&e&&(w.Mb(0,"div",0),w.mc(1,I,4,2,"ng-container",1),w.Lb(),w.Ib(2,"div",2)),2&e&&(w.xb(1),w.ac("ngForOf",t.menuSchema))},directives:[c.j,c.k],pipes:[C.c],styles:[".dataset-sidemenu-container[_ngcontent-%COMP%]{display:flex;flex-wrap:wrap;flex-direction:column;width:16vw}.new-project-container[_ngcontent-%COMP%]{margin-bottom:5vh;margin-left:2vw}.new-project-btn[_ngcontent-%COMP%]{padding:1vw;border-radius:5vh;background-color:#525353;border:none;color:#fff;outline:none;cursor:pointer;display:flex;justify-content:space-around;align-items:center;min-width:10vw;max-width:10vw;min-height:4vh;max-height:4vh}.new-project-btn[_ngcontent-%COMP%]:hover{background-color:#393838}.add-icon[_ngcontent-%COMP%]{min-height:inherit;max-height:inherit}.new-project-txt[_ngcontent-%COMP%]{border:none;background:none;outline:none;cursor:pointer;font-size:2vh;color:#fff;text-align:start;white-space:nowrap}.current-project-btn[_ngcontent-%COMP%]{color:#fff;cursor:pointer;display:flex;align-items:center;border-radius:5vh;padding:1vh 1vw;margin-left:2vw;min-width:10vw;max-width:10vw;min-height:5vh;max-height:5vh;flex:1 1 100%}.current-project-btn[_ngcontent-%COMP%]:hover{background-color:#525353}.project-icon[_ngcontent-%COMP%]{min-height:4vh;max-height:4vh;flex:1 1 10%}.current-project-txt[_ngcontent-%COMP%]{border:none;background:none;outline:none;cursor:pointer;font-size:2vh;color:#fff;white-space:nowrap;flex:1 1 90%;text-align:left;padding-left:20px}.horizontal-line[_ngcontent-%COMP%]{width:12vw;background-color:#393838;min-height:.3vh;max-height:.3vh;margin:auto;border:.0625rem solid #000}"]}),F),T=((N=function(){function e(){a(this,e)}return i(e,[{key:"ngOnInit",value:function(){}}]),e}()).\u0275fac=function(e){return new(e||N)},N.\u0275cmp=w.Bb({type:N,selectors:[["data-set-header"]],decls:6,vars:3,consts:[[1,"dataset-header-container"],[1,"label"],[1,"dataset-icon-container"]],template:function(e,t){1&e&&(w.Mb(0,"div",0),w.Mb(1,"label",1),w.oc(2),w.Wb(3,"translate"),w.Lb(),w.Mb(4,"div",2),w.Ib(5,"div"),w.Lb(),w.Lb()),2&e&&(w.xb(2),w.pc(w.Xb(3,1,"datasetHeader.datasetManagement")))},pipes:[C.c],styles:[".dataset-header-container[_ngcontent-%COMP%]{display:flex;justify-content:space-around;align-items:center;padding:1vw;min-width:80vw;max-width:80vw}.label[_ngcontent-%COMP%]{flex:1 1 80%;background:none;font-size:2.5vh;color:#fff;white-space:nowrap;min-height:inherit;max-height:inherit}.dataset-icon-container[_ngcontent-%COMP%]{display:flex;justify-content:space-between;align-items:center;flex:1 1 20%}.dataset-icon[_ngcontent-%COMP%]{flex:1 1 3%;min-width:2vw;max-width:2vw;cursor:pointer}.dataset-icon[_ngcontent-%COMP%]:hover{border-radius:5vh;background-color:#393838}.dataset-select[_ngcontent-%COMP%]{min-height:4vh;max-height:4vh;font-size:2vh;min-width:7vw;max-width:7vw;-moz-text-align-last:center;background:#000;color:#fff;border:.1vw solid;text-align-last:center}.dataset-select[_ngcontent-%COMP%]:focus, .dataset-select[_ngcontent-%COMP%]:hover{background:#393838}.dataset-select[_ngcontent-%COMP%]:focus, .dataset-select[_ngcontent-%COMP%]:hover, select[_ngcontent-%COMP%]{-moz-appearance:none;-webkit-appearance:none}option[_ngcontent-%COMP%]{background:#000;text-align:center}"]}),N);function D(e,t){1&e&&(w.Kb(0),w.Mb(1,"div",2),w.Mb(2,"div",3),w.Mb(3,"div",4),w.Mb(4,"label",5),w.oc(5),w.Wb(6,"translate"),w.Lb(),w.Lb(),w.Mb(7,"div"),w.Mb(8,"label",6),w.oc(9),w.Wb(10,"translate"),w.Lb(),w.Lb(),w.Lb(),w.Lb(),w.Jb()),2&e&&(w.xb(5),w.pc(w.Xb(6,2,"datasetCard.fetchingProject")),w.xb(4),w.pc(w.Xb(10,4,"datasetCard.pleaseWait")))}function W(e,t){1&e&&(w.Kb(0),w.Mb(1,"label",22),w.oc(2),w.Wb(3,"translate"),w.Lb(),w.Jb()),2&e&&(w.xb(2),w.qc(" ",w.Xb(3,1,"datasetCard.uploading")," "))}function z(e,t){1&e&&(w.Kb(0),w.Mb(1,"label",24),w.oc(2),w.Wb(3,"translate"),w.Lb(),w.Jb()),2&e&&(w.xb(2),w.pc(w.Xb(3,1,"datasetCard.new")))}function X(e,t){1&e&&(w.Kb(0),w.Mb(1,"label",25),w.oc(2),w.Wb(3,"translate"),w.Lb(),w.Jb()),2&e&&(w.xb(2),w.pc(w.Xb(3,1,"datasetCard.available")))}function R(e,t){1&e&&(w.Kb(0),w.Mb(1,"label",26),w.oc(2),w.Wb(3,"translate"),w.Lb(),w.Jb()),2&e&&(w.xb(2),w.pc(w.Xb(3,1,"datasetCard.opened")))}function U(e,t){if(1&e&&(w.Kb(0,23),w.mc(1,z,4,3,"ng-container",16),w.mc(2,X,4,3,"ng-container",16),w.mc(3,R,4,3,"ng-container",16),w.Jb()),2&e){var n=w.Vb().$implicit;w.ac("ngSwitch",n),w.xb(1),w.ac("ngIf",n.is_new),w.xb(1),w.ac("ngIf",!n.is_new&&!n.is_loaded),w.xb(1),w.ac("ngIf",!n.is_new&&n.is_loaded)}}function V(e,t){if(1&e){var n=w.Nb();w.Kb(0),w.Mb(1,"span"),w.Mb(2,"div",27),w.Mb(3,"div",28),w.Tb("click",function(){w.hc(n);var e=w.Vb().$implicit;return w.Vb(3).onRenameProject(e.project_name)}),w.oc(4),w.Wb(5,"translate"),w.Lb(),w.Mb(6,"div",28),w.Tb("click",function(){w.hc(n);var e=w.Vb().$implicit;return w.Vb(3).onDeleteProject(e.project_name)}),w.oc(7),w.Wb(8,"translate"),w.Lb(),w.Lb(),w.Lb(),w.Jb()}2&e&&(w.xb(4),w.qc(" ",w.Xb(5,2,"datasetCard.renameProject")," "),w.xb(3),w.qc(" ",w.Xb(8,4,"datasetCard.deleteProject")," "))}var q=function(e){return[e]};function J(e,t){if(1&e){var n=w.Nb();w.Kb(0),w.Mb(1,"div",9),w.Tb("dblclick",function(){w.hc(n);var e=t.index,o=t.$implicit;return w.Vb(3).onOpenProject(e,o)}),w.Mb(2,"div",10),w.Mb(3,"div"),w.mc(4,W,4,3,"ng-container",0),w.mc(5,U,4,4,"ng-template",null,11,w.nc),w.Lb(),w.Mb(7,"div",12),w.Mb(8,"div",13),w.Tb("click",function(){w.hc(n);var e=t.$implicit;return w.Vb(3).onStarred(e,!e.is_starred)})("dblclick",function(e){return w.hc(n),w.Vb(3).onDblClickStopPropagate(e)}),w.Ib(9,"img",14),w.Lb(),w.Mb(10,"div",13),w.Tb("click",function(){w.hc(n);var e=t.index;return w.Vb(3).onDisplayMore(e)})("dblclick",function(e){return w.hc(n),w.Vb(3).onDblClickStopPropagate(e)}),w.Ib(11,"img",15),w.Lb(),w.mc(12,V,9,6,"ng-container",16),w.Lb(),w.Lb(),w.Mb(13,"div",17),w.Mb(14,"label",18),w.Mb(15,"div",19),w.oc(16),w.Wb(17,"translate"),w.Lb(),w.Lb(),w.Lb(),w.Mb(18,"div",20),w.Mb(19,"label",18),w.Mb(20,"div",21),w.oc(21),w.Lb(),w.Lb(),w.Lb(),w.Mb(22,"div",20),w.Mb(23,"label",18),w.Mb(24,"div",21),w.oc(25),w.Wb(26,"translate"),w.Lb(),w.Lb(),w.Lb(),w.Lb(),w.Jb()}if(2&e){var o=t.$implicit,a=t.index,r=w.fc(6),i=w.Vb(3);w.xb(1),w.yb("data-index",a),w.xb(3),w.ac("ngIf",i.isExactIndex(a)&&i._jsonSchema.isUploading)("ngIfElse",r),w.xb(5),w.ac("src",w.dc(17,q,o.is_starred?i.starredActiveIcon:i.starredInactiveIcon),w.jc),w.xb(3),w.ac("ngIf",i.isExactIndex(a)),w.xb(2),w.ac("title",o.created_date),w.xb(2),w.rc(" ",w.Xb(17,13,"datasetCard.created")," ",o.created_date," "),w.xb(3),w.ac("title",o.project_name),w.xb(2),w.qc(" ",o.project_name," "),w.xb(2),w.ac("title","Total Photo: "+o.total_uuid),w.xb(2),w.rc(" ",w.Xb(26,15,"datasetCard.totalPhoto")," ",o.total_uuid," ")}}function A(e,t){if(1&e&&(w.Kb(0),w.Mb(1,"div",2),w.mc(2,J,27,19,"ng-container",8),w.Lb(),w.Jb()),2&e){var n=w.Vb(2);w.xb(2),w.ac("ngForOf",n._jsonSchema.projects)}}function $(e,t){1&e&&(w.Mb(0,"div",2),w.Mb(1,"div",3),w.Mb(2,"div",4),w.Mb(3,"label",5),w.oc(4),w.Wb(5,"translate"),w.Lb(),w.Lb(),w.Mb(6,"div"),w.Mb(7,"label",6),w.oc(8),w.Wb(9,"translate"),w.Lb(),w.Lb(),w.Lb(),w.Lb()),2&e&&(w.xb(4),w.pc(w.Xb(5,2,"datasetCard.noProject")),w.xb(4),w.pc(w.Xb(9,4,"datasetCard.createNew")))}function B(e,t){if(1&e&&(w.mc(0,A,3,1,"ng-container",0),w.mc(1,$,10,6,"ng-template",null,7,w.nc)),2&e){var n=w.fc(2),o=w.Vb();w.ac("ngIf",o._jsonSchema.projects.length>0)("ngIfElse",n)}}var K,H=((K=function(){function e(t){var n=this;a(this,e),this._cd=t,this._onClick=new w.n,this._onStarred=new w.n,this._onDelete=new w.n,this._onRename=new w.n,this.starredActiveIcon="../../../assets/icons/starred_active.svg",this.starredInactiveIcon="../../../assets/icons/starred.svg",this.cardSchema={clickIndex:-1},this.previousProjectLength=0,this.conditionalDisableProject=function(e){return e.is_loaded?"disabled":"enabled"},this.conditionalDisableClickEvent=function(e){return e},this.onOpenProject=function(e,t){var o=t.project_name;!n.isExactIndex(e)&&n._onClick.emit(o)},this.onDisplayMore=function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:n.cardSchema.clickIndex,t=n.cardSchema.clickIndex;n.cardSchema={clickIndex:t===e?-1:e}},this.onCloseDisplay=function(){n.cardSchema.clickIndex=-1},this.onStarred=function(e,t){var o=e.project_name;n._jsonSchema.projects=n._jsonSchema.projects.map(function(e){return e.project_name===o?(e.is_starred=t,e):e}),n._onStarred.emit({projectName:o,starred:t})},this.isExactIndex=function(e){return e===n.cardSchema.clickIndex},this.onDblClickStopPropagate=function(e){return e.stopPropagation()}}return i(e,[{key:"ngOnInit",value:function(){}},{key:"onRenameProject",value:function(e){this._onRename.emit({shown:!0,projectName:e}),this.onCloseDisplay()}},{key:"onDeleteProject",value:function(e){this._onDelete.emit(e),this.onCloseDisplay()}},{key:"ngOnChanges",value:function(e){!e._jsonSchema.currentValue.isUploading&&this.onDisplayMore(),this._jsonSchema.projects.length!==this.previousProjectLength&&(this.cardSchema.clickIndex=-1),this.previousProjectLength=this._jsonSchema.projects.length}}]),e}()).\u0275fac=function(e){return new(e||K)(w.Hb(w.h))},K.\u0275cmp=w.Bb({type:K,selectors:[["data-set-card"]],inputs:{_jsonSchema:"_jsonSchema"},outputs:{_onClick:"_onClick",_onStarred:"_onStarred",_onDelete:"_onDelete",_onRename:"_onRename"},features:[w.vb],decls:3,vars:2,consts:[[4,"ngIf","ngIfElse"],["showCardBody",""],[1,"card-layout-container","scroll","fade-in"],[1,"no-project-card-container"],[1,"no-project-title-padding"],[1,"no-project-title"],[1,"no-project-subtitle"],["noProject",""],[4,"ngFor","ngForOf"],[1,"card-container",3,"dblclick"],[1,"card-header-style"],["newLabel",""],[1,"card-icon-container"],[3,"click","dblclick"],[1,"card-icon-style",3,"src"],["src","../../../assets/icons/more.svg",1,"card-icon-style","enabled"],[4,"ngIf"],[1,"card-title-style"],[3,"title"],[1,"card-title-txt"],[1,"project-name-style"],[1,"project-info"],[1,"project-status-uploading"],[3,"ngSwitch"],[1,"project-status-new"],[1,"project-status-available"],[1,"project-status-opened"],[1,"popup-container","enabled"],[1,"popup-label",3,"click"]],template:function(e,t){if(1&e&&(w.mc(0,D,11,6,"ng-container",0),w.mc(1,B,3,2,"ng-template",null,1,w.nc)),2&e){var n=w.fc(2);w.ac("ngIf",t._jsonSchema.isFetching)("ngIfElse",n)}},directives:[c.k,c.j,c.m],pipes:[C.c],styles:['@keyframes fade-in{0%{opacity:0}to{opacity:1}}@-webkit-keyframes fade-in{0%{opacity:0}to{opacity:1}}.fade-in[_ngcontent-%COMP%]{animation:fadeIn 1.5s ease;-webkit-animation:fadeIn 1.5s ease;-moz-animation:fadeIn ease 1.5s;-o-animation:fadeIn ease 1.5s;-ms-animation:fadeIn ease 1.5s}.card-layout-container[_ngcontent-%COMP%]{width:80vw;display:flex;flex-wrap:wrap;padding:0 0 0 1vw;overflow-y:scroll;position:relative;height:80vh}.scroll[_ngcontent-%COMP%]::-webkit-scrollbar-track{box-shadow:inset 0 0 6px rgba(0,0,0,.3);border-radius:10px;background-color:#000}.scroll[_ngcontent-%COMP%]::-webkit-scrollbar{width:.5vw}.scroll[_ngcontent-%COMP%]::-webkit-scrollbar-thumb{border-radius:10px;box-shadow:inset 0 0 6px rgba(0,0,0,.3);background-color:#525353}.card-container[_ngcontent-%COMP%]{min-width:11vw;max-width:11vw;min-height:30vh;max-height:30vh;border-style:solid;font-size:2.2vh;background:#2e2d2d;position:relative}.card-container[_ngcontent-%COMP%]:hover{background:#404040}.card-container[_ngcontent-%COMP%]:before{content:"";display:block;height:100%;position:absolute;top:0;left:0;width:.3vw;background-color:#363636}.enabled[_ngcontent-%COMP%]{cursor:pointer}.disabled[_ngcontent-%COMP%]{cursor:not-allowed}.project-status-new[_ngcontent-%COMP%]{background-color:#f59221}.project-status-available[_ngcontent-%COMP%], .project-status-new[_ngcontent-%COMP%]{color:#f5f5f5;font-size:1.5vh;padding:.3vh 1.5vw .6vh 1vw}.project-status-available[_ngcontent-%COMP%]{background-color:#92c91b}.project-status-opened[_ngcontent-%COMP%]{background-color:#258fc0}.project-status-opened[_ngcontent-%COMP%], .project-status-uploading[_ngcontent-%COMP%]{color:#f5f5f5;font-size:1.5vh;padding:.3vh 1.5vw .6vh 1vw}.project-status-uploading[_ngcontent-%COMP%]{background-color:#f5219d}.card-icon-container[_ngcontent-%COMP%]{display:flex}.card-icon-style[_ngcontent-%COMP%]{min-width:1.5vw;max-width:1.5vw;min-height:3vh;max-height:3vh}.card-icon-style[_ngcontent-%COMP%]:hover{border-radius:5vh;background-color:#393838}.card-header-style[_ngcontent-%COMP%]{margin-top:1vh;display:flex;flex-direction:row;justify-content:space-between;position:relative}.card-title-style[_ngcontent-%COMP%]{margin-left:1vw}.card-title-txt[_ngcontent-%COMP%]{color:#656667;font-size:1.3vh;white-space:nowrap;overflow:hidden;text-overflow:ellipsis}.project-name-style[_ngcontent-%COMP%]{margin-left:1vw;padding:1vh 0 0}.project-info[_ngcontent-%COMP%]{color:#dbdbda;font-size:2vh;white-space:nowrap;overflow:hidden;text-overflow:ellipsis}.tag-container[_ngcontent-%COMP%]{display:flex;flex-direction:row;border-radius:10vw;background:#363636;width:4.5vw;padding:.2vw .3vh;cursor:pointer;outline:none;border:none;margin:.8vh 0 0 1vw}.tag-img[_ngcontent-%COMP%]{min-height:2vh;max-height:2vh;min-width:1vw;max-width:1vw;margin-left:.35vw}.tag-txt[_ngcontent-%COMP%]{font-size:1.2vh;color:#fff;padding:.2vh 0 0 .3vw;cursor:pointer}.popup-container[_ngcontent-%COMP%]{overflow:hidden;position:absolute;margin:4vh 0 0 -10vw;padding:.5vw;border-radius:.2vw;box-shadow:0 2px 5px 0 rgba(var(--shadow-rgb),.26),0 2px 10px 0 rgba(var(--shadow-rgb),.16);transform-origin:left top;transform:scale(1);opacity:1;white-space:nowrap;background:#fff;font-size:1.5vh;-webkit-animation:appear .35s ease-in 1;animation:appear .35s ease-in 1}@-webkit-keyframes appear{0%{opacity:0;transform:translateY(-10px)}}@keyframes appear{0%{opacity:0;transform:translateY(-10px)}}.popup-label[_ngcontent-%COMP%]{font-size:2vh;padding:.5vw}.popup-label[_ngcontent-%COMP%]:hover{background:#e9e9e9}.no-project-title[_ngcontent-%COMP%]{font-size:4vh;color:#fff;white-space:nowrap}.no-project-title-padding[_ngcontent-%COMP%]{padding:2vw}.no-project-subtitle[_ngcontent-%COMP%]{font-size:2vh;color:#bebebe;white-space:nowrap}.no-project-card-container[_ngcontent-%COMP%]{display:flex;flex-direction:column;justify-content:center;align-items:center;background-color:#1f1f1f;width:100%}']}),K),G=r("44N4"),Y=r("TJKd"),Z=["refProjectName"],Q=["labeltextfilename"],ee=["refNewProjectName"];function te(e,t){if(1&e&&(w.Mb(0,"div",25),w.Mb(1,"p",26),w.oc(2),w.Lb(),w.Lb()),2&e){var n=w.Vb();w.xb(2),w.qc(" ",n.isImageUploading?"Uploading the Images. Please Wait...":"Selection Window is Opened"," ")}}function ne(e,t){1&e&&(w.Mb(0,"span"),w.Mb(1,"small",28),w.oc(2),w.Wb(3,"translate"),w.Lb(),w.Lb()),2&e&&(w.xb(2),w.qc(" ",w.Xb(3,1,"projectNameExist")," "))}function oe(e,t){1&e&&(w.Mb(0,"span"),w.Mb(1,"small",28),w.oc(2),w.Wb(3,"translate"),w.Lb(),w.Lb()),2&e&&(w.xb(2),w.qc(" ",w.Xb(3,1,"projectNameRequired")," "))}function ae(e,t){if(1&e&&(w.Kb(0),w.Mb(1,"div",27),w.mc(2,ne,4,3,"span",12),w.mc(3,oe,4,3,"span",12),w.Lb(),w.Jb()),2&e){var n=w.Vb(),o=null,a=null;w.xb(2),w.ac("ngIf",null==(o=n.form.get("projectName"))?null:o.getError("exist")),w.xb(1),w.ac("ngIf",null==(a=n.form.get("projectName"))?null:a.getError("required"))}}function re(e,t){1&e&&(w.Mb(0,"span"),w.Mb(1,"small",28),w.oc(2),w.Wb(3,"translate"),w.Lb(),w.Lb()),2&e&&(w.xb(2),w.qc(" ",w.Xb(3,1,"projectNameExist")," "))}function ie(e,t){1&e&&(w.Mb(0,"span"),w.Mb(1,"small",28),w.oc(2),w.Wb(3,"translate"),w.Lb(),w.Lb()),2&e&&(w.xb(2),w.qc(" ",w.Xb(3,1,"projectNameRequired")," "))}function ce(e,t){if(1&e&&(w.Kb(0),w.Mb(1,"div",27),w.mc(2,re,4,3,"span",12),w.mc(3,ie,4,3,"span",12),w.Lb(),w.Jb()),2&e){var n=w.Vb(),o=null,a=null;w.xb(2),w.ac("ngIf",null==(o=n.renameForm.get("newProjectName"))?null:o.getError("exist")),w.xb(1),w.ac("ngIf",null==(a=n.renameForm.get("newProjectName"))?null:a.getError("required"))}}var se,le,be,de=[{path:"",component:(se=function(){function n(o,r,i,c,w,_,P){var x=this;a(this,n),this._fb=o,this._router=r,this._dataSetService=i,this._spinnerService=c,this._imgLblModeService=w,this._languageService=_,this._modalService=P,this.onChangeSchema={currentThumbnailIndex:-1,thumbnailName:"",totalNumThumbnail:0,status:void 0},this.projectList={projects:[],isUploading:!1,isFetching:!1},this.inputProjectName="",this.newInputProjectName="",this.selectedProjectName="",this.oldProjectName="",this.labelTextUpload=[],this.subject$=new f.a,this.thumbnailList=[],this.labelList=[],this.unsubscribe$=new f.a,this.isLoading=!1,this.isOverlayOn=!1,this.isImageUploading=!1,this.isProjectLoading=!1,this.imgLblMode=null,this.modalIdCreateProject="modal-create-project",this.modalIdRenameProject="modal-rename-project",this.createProjectModalBodyStyle={minHeight:"35vh",maxHeight:"35vh",minWidth:"31vw",maxWidth:"31vw",margin:"15vw 71vh",overflow:"none"},this.renameProjectModalBodyStyle={minHeight:"23vh",maxHeight:"23vh",minWidth:"31vw",maxWidth:"31vw",margin:"15vw 71vh",overflow:"none"},this.showProjectList=function(){x.projectList.isFetching=!0,x._dataSetService.getProjectList().pipe(Object(l.a)()).subscribe(function(e){var t=e.content;if(t){var n=Object(s.a)(t).map(function(e){return Object.assign(Object.assign({},e),{created_date:x.formatDate(e.created_date)})});x.projectList=Object.assign(Object.assign({},x.projectList),{projects:n,isFetching:!1})}})},this.formatDate=function(e){var t=new Date(e),n=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"].find(function(e,n){return n===t.getMonth()||void 0});return n?"".concat(n,"-").concat(t.getDate(),"-").concat(t.getFullYear()):"Error"},this.createFormControls=function(){x.form=x._fb.group({projectName:["",j.l.required]})},this.renameFormControls=function(){x.renameForm=x._fb.group({newProjectName:["",j.l.required]})},this.onChange=function(e){x.inputProjectName=e},this.onChangeRename=function(e){x.newInputProjectName=e},this.toggleModalDisplay=function(e){x._labelTextFilename.nativeElement.innerHTML="",x.labelTextUpload=[],e&&x.form.reset(),e?x._modalService.open(x.modalIdCreateProject):x._modalService.close(x.modalIdCreateProject)},this.toggleRenameModalDisplay=function(e){if(e){var t=e.shown,n=e.projectName;t?(x.renameForm.reset(),x._modalService.open(x.modalIdRenameProject)):x._modalService.close(x.modalIdRenameProject),x.oldProjectName=n}else x._modalService.close(x.modalIdRenameProject)},this.importProject=function(){var e=x._dataSetService.importStatus();x._dataSetService.importProject().pipe(Object(l.a)(),Object(b.a)(function(e){return e.message})).subscribe(function(t){var n=!1;Object(g.a)(500).pipe(Object(d.a)(function(){return e}),Object(l.a)(function(e){return x.isOverlayOn=0===e.message,1!==e.message&&4!==e.message||(n=!0),n})).subscribe(function(e){x.showProjectList()})})},this.onStarred=function(e){var t=e.projectName,n=e.starred;x._dataSetService.updateProjectStatus(t,n,"star").pipe(Object(l.a)()).subscribe(function(e){var t=e.message;return console.log(t)},function(e){return x.projectList={isUploading:x.projectList.isUploading,isFetching:x.projectList.isFetching,projects:x.projectList.projects.map(function(e){return e.project_name===t?Object.assign(Object.assign({},e),{is_starred:!1}):e})}})},this.onSubmit=function(e,t){var n,o,a;x.form.markAllAsTouched(),e?x.inputProjectName?x.projectList.projects&&x.projectList.projects.find(function(e){return e&&e.project_name===x.inputProjectName})?(null===(n=x.form.get("projectName"))||void 0===n||n.setErrors({exist:!0}),x._refProjectName.nativeElement.focus()):(x.createProject(x.inputProjectName),x.selectedProjectName=null===(o=x.form.get("projectName"))||void 0===o?void 0:o.value):(null===(a=x.form.get("projectName"))||void 0===a||a.setErrors({required:!0}),x._refProjectName.nativeElement.focus()):t&&x.startProject(t)},this.startProject=function(n){x.selectedProjectName=n;var o=x._dataSetService.checkProjectStatus(n),a=x._dataSetService.updateProjectLoadStatus(n),r=x._dataSetService.checkExistProjectStatus(n),i=x._dataSetService.getThumbnailList;x.subjectSubscription=x.subject$.pipe(Object(u.a)(function(){return Object(h.a)([o])}),Object(l.a)(function(e){var n=t(e,1)[0],o=n.message,a=n.content;return x.projectList={isUploading:x.projectList.isUploading,isFetching:x.projectList.isFetching,projects:x.projectList.projects.map(function(e){return e.project_name===a[0].project_name?Object.assign(Object.assign({},a[0]),{created_date:e.created_date}):e})},1===o}),Object(u.a)(function(e){return t(e,1)[0].message?Object(h.a)([a,r]):[]}),Object(u.a)(function(o){var a=t(o,2);!function(e){if(null==e)throw new TypeError("Cannot destructure undefined")}(a[0]);var c=a[1],s=c.message,b=c.uuid_list,d=c.label_list;return 2===s?(x.labelList=e(d),b.length>0?b.map(function(e){return i(n,e)}):[]):Object(g.a)(500).pipe(Object(u.a)(function(){return r}),Object(l.a)(function(e){return 2===e.message}),Object(u.a)(function(t){var o=t.uuid_list,a=t.label_list;return x.labelList=e(a),o.length>0?o.map(function(e){return i(n,e)}):[]}))}),Object(u.a)(function(e){return e})).subscribe(function(t){x.isProjectLoading=!0,x.thumbnailList=[].concat(e(x.thumbnailList),[t])},function(e){},function(){x.isProjectLoading=!1,x._router.navigate(["imglabel/"+x.imgLblMode],{state:{thumbnailList:x.thumbnailList,projectName:n,labelList:x.labelList}}),x._spinnerService.hideSpinner()}),x.subject$.next()},this.createProject=function(e){var t=x._dataSetService.createNewProject(e),n=x._dataSetService.updateLabelList(e,x.labelTextUpload),o=x._dataSetService.localUploadStatus(e),a=0;x.projectList=Object.assign(Object.assign({},x.projectList),{isUploading:!0}),x.subjectSubscription=x.subject$.pipe(Object(l.a)(),Object(u.a)(function(){return t}),Object(u.a)(function(){return n}),Object(u.a)(function(e){return function(e){var t=e.message;return 5===t||1!==t&&0!==t?Object(v.a)(function(e){return console.error(e),x.projectList=Object.assign(Object.assign({},x.projectList),{isUploading:!1}),e}):Object(g.a)(500).pipe(Object(u.a)(function(){return o}),Object(l.a)(function(e){var t=e.message;return x.isOverlayOn=0===t||2===t,x.isImageUploading=2===t,4===t||1===t}))}(e)})).subscribe(function(e){4===e.message&&x.toggleModalDisplay(!1),x.isProjectLoading=!0,(a=e?--a:a)<1&&(x.projectList=Object.assign(Object.assign({},x.projectList),{isUploading:!1}))},function(e){},function(){x.isProjectLoading=!1,x.showProjectList()}),x.subject$.next()},this.renameProject=function(e,t){x._dataSetService.renameProject(e,t).pipe(Object(l.a)(),Object(b.a)(function(e){return e.message})).subscribe(function(t){1===t&&(x._languageService._translate.get("renameSuccess").subscribe(function(t){alert(e+" "+t)}),x.showProjectList(),x.toggleRenameModalDisplay())})},this.deleteProject=function(e){x._dataSetService.deleteProject(e).pipe(Object(l.a)(),Object(b.a)(function(e){return e.message})).subscribe(function(t){1===t&&(x._languageService._translate.get("deleteSuccess").subscribe(function(t){alert(e+" "+t)}),x.showProjectList())})},this.keyDownEvent=function(e){"Escape"===e.key&&x.toggleRenameModalDisplay()&&x.toggleModalDisplay(!1)},this._imgLblModeService.imgLabelMode$.pipe(Object(m.a)()).subscribe(function(e){return x.imgLblMode=e}),this._spinnerService.returnAsObservable().pipe(Object(p.a)(this.unsubscribe$)).subscribe(function(e){return x.isLoading=e}),this.createFormControls(),this.renameFormControls(),this._languageService.initializeLanguage("data-set-page",["data-set-page-en","data-set-page-cn","data-set-page-ms"])}return i(n,[{key:"ngOnInit",value:function(){this.showProjectList()}},{key:"onSubmitRename",value:function(){var e,t,n,o=this;this.renameForm.markAllAsTouched(),this.newInputProjectName?this.projectList.projects&&this.projectList.projects.find(function(e){return e?e.project_name===o.newInputProjectName:null})?(null===(e=this.renameForm.get("newProjectName"))||void 0===e||e.setErrors({exist:!0}),this._refProjectName.nativeElement.focus()):(this.renameProject(this.oldProjectName,this.newInputProjectName),this.selectedProjectName=null===(t=this.renameForm.get("newProjectName"))||void 0===t?void 0:t.value):(null===(n=this.renameForm.get("newProjectName"))||void 0===n||n.setErrors({required:!0}),this._refProjectName.nativeElement.focus())}},{key:"importLabelFile",value:function(){var e=this,t=this._dataSetService.importLabelFileStatus();this._dataSetService.importLabelFile().pipe(Object(l.a)(),Object(b.a)(function(e){return e.message})).subscribe(function(n){var o=!1;Object(g.a)(500).pipe(Object(d.a)(function(){return t}),Object(l.a)(function(t){return e.isOverlayOn=0===t.message,4===t.message&&(e._labelTextFilename.nativeElement.innerHTML=t.label_file_path.replace(/^.*[\\\/]/,""),e.labelTextUpload=t.label_list),1!==t.message&&4!==t.message||(o=!0),o})).subscribe(function(t){e.showProjectList()})})}},{key:"onWindowClose",value:function(e){e.preventDefault(),this.isProjectLoading&&(e.returnValue="Are you sure you want to leave this page?")}},{key:"ngOnDestroy",value:function(){this.unsubscribe$.next(),this.unsubscribe$.complete()}}]),n}(),se.\u0275fac=function(e){return new(e||se)(w.Hb(j.b),w.Hb(_.a),w.Hb(P.a),w.Hb(x.a),w.Hb(M.a),w.Hb(y.a),w.Hb(O.a))},se.\u0275cmp=w.Bb({type:se,selectors:[["data-set-layout"]],viewQuery:function(e,t){var n;1&e&&(w.sc(Z,!0),w.sc(Q,!0),w.sc(ee,!0)),2&e&&(w.ec(n=w.Ub())&&(t._refProjectName=n.first),w.ec(n=w.Ub())&&(t._labelTextFilename=n.first),w.ec(n=w.Ub())&&(t._refNewProjectName=n.first))},hostBindings:function(e,t){1&e&&w.Tb("keydown",function(e){return t.keyDownEvent(e)},!1,w.gc)("beforeunload",function(e){return t.onWindowClose(e)},!1,w.gc)},decls:50,vars:40,consts:[["class","overlay",4,"ngIf"],[3,"_onChange"],[1,"upper-container"],[3,"_onCreate","_onImport"],[3,"_jsonSchema","_onClick","_onStarred","_onDelete","_onRename"],[3,"id","modalBodyStyle","modalTitle","scrollable"],[3,"formGroup"],[1,"content-container"],[1,"new-project-container"],[1,"label"],["type","text","placeholder","Enter project name","formControlName","projectName",1,"input-style",3,"value","input"],["refProjectName",""],[4,"ngIf"],[1,"select-file-container"],[1,"label","label-file"],["type","button",1,"button-style","choose-file-button",3,"click"],[1,"file-name-container"],[1,"filename"],["labeltextfilename",""],[1,"horizontal-line"],[1,"model-button-container"],["type","submit",1,"button-style","create-btn",3,"click"],["type","text","placeholder","Enter new project name","formControlName","newProjectName",1,"input-style",3,"value","input"],["refNewProjectName",""],[3,"_loading"],[1,"overlay"],[2,"margin-top","40vh","color","rgb(255, 255, 255, 0.9)","text-align","center","font-size","3vh"],[1,"validation"],[1,"error-msg"]],template:function(e,t){var n,o;(1&e&&(w.mc(0,te,3,1,"div",0),w.Ib(1,"page-header",1),w.Mb(2,"div",2),w.Mb(3,"data-set-side-menu",3),w.Tb("_onCreate",function(e){return t.toggleModalDisplay(e)})("_onImport",function(){return t.importProject()}),w.Lb(),w.Mb(4,"div"),w.Ib(5,"data-set-header"),w.Mb(6,"data-set-card",4),w.Tb("_onClick",function(e){return t.onSubmit(!1,e)})("_onStarred",function(e){return t.onStarred(e)})("_onDelete",function(e){return t.deleteProject(e)})("_onRename",function(e){return t.toggleRenameModalDisplay(e)}),w.Lb(),w.Lb(),w.Lb(),w.Mb(7,"modal",5),w.Wb(8,"translate"),w.Mb(9,"form",6),w.Mb(10,"div",7),w.Mb(11,"div",8),w.Mb(12,"label",9),w.oc(13),w.Wb(14,"translate"),w.Lb(),w.Mb(15,"input",10,11),w.Tb("input",function(e){return t.onChange(e.target.value)}),w.Lb(),w.Lb(),w.mc(17,ae,4,2,"ng-container",12),w.Mb(18,"div",13),w.Mb(19,"label",14),w.oc(20),w.Wb(21,"translate"),w.Lb(),w.Mb(22,"button",15),w.Tb("click",function(){return t.importLabelFile()}),w.oc(23),w.Wb(24,"translate"),w.Lb(),w.Lb(),w.Mb(25,"div",16),w.Ib(26,"label",17,18),w.Lb(),w.Ib(28,"div",19),w.Mb(29,"div",20),w.Mb(30,"button",21),w.Tb("click",function(){return t.onSubmit(!0)}),w.oc(31),w.Wb(32,"translate"),w.Lb(),w.Lb(),w.Lb(),w.Lb(),w.Lb(),w.Mb(33,"modal",5),w.Wb(34,"translate"),w.Mb(35,"form",6),w.Mb(36,"div",7),w.Mb(37,"div",8),w.Mb(38,"label",9),w.oc(39),w.Wb(40,"translate"),w.Lb(),w.Mb(41,"input",22,23),w.Tb("input",function(e){return t.onChangeRename(e.target.value)}),w.Lb(),w.Lb(),w.mc(43,ce,4,2,"ng-container",12),w.Ib(44,"div",19),w.Mb(45,"div",20),w.Mb(46,"button",21),w.Tb("click",function(){return t.onSubmitRename()}),w.oc(47),w.Wb(48,"translate"),w.Lb(),w.Lb(),w.Lb(),w.Lb(),w.Lb(),w.Ib(49,"spinner",24)),2&e)&&(w.ac("ngIf",t.isOverlayOn),w.xb(1),w.ac("_onChange",t.onChangeSchema),w.xb(5),w.ac("_jsonSchema",t.projectList),w.xb(1),w.ac("id",t.modalIdCreateProject)("modalBodyStyle",t.createProjectModalBodyStyle)("modalTitle",w.Xb(8,24,"createNewProject"))("scrollable",!1),w.xb(2),w.ac("formGroup",t.form),w.xb(4),w.qc("",w.Xb(14,26,"newProjectName")," "),w.xb(2),w.ac("value",t.inputProjectName),w.xb(2),w.ac("ngIf",null==(n=t.form.get("projectName"))?null:n.touched),w.xb(3),w.qc("",w.Xb(21,28,"labelListFile")," "),w.xb(3),w.qc(" ",w.Xb(24,30,"chooseFile")," "),w.xb(8),w.qc(" ",w.Xb(32,32,"createButton")," "),w.xb(2),w.ac("id",t.modalIdRenameProject)("modalBodyStyle",t.renameProjectModalBodyStyle)("modalTitle",w.Xb(34,34,"renameProject"))("scrollable",!1),w.xb(2),w.ac("formGroup",t.renameForm),w.xb(4),w.qc("",w.Xb(40,36,"newProjectName")," "),w.xb(2),w.ac("value",t.inputProjectName),w.xb(2),w.ac("ngIf",null==(o=t.renameForm.get("newProjectName"))?null:o.touched),w.xb(4),w.qc(" ",w.Xb(48,38,"updateButton")," "),w.xb(2),w.ac("_loading",t.isLoading))},directives:[c.k,L.a,E,T,H,G.a,j.n,j.g,j.d,j.a,j.f,j.c,Y.a],pipes:[C.c],styles:[".upper-container[_ngcontent-%COMP%]{display:flex;margin-top:5vh}.model[_ngcontent-%COMP%]{z-index:1000;padding-top:10vh;top:0;width:100%;height:100%;overflow:auto;background-color:transparent;scrollbar-width:none;position:fixed;background:rgba(0,0,0,.7)}.model-content[_ngcontent-%COMP%]{background-color:#525353;padding:1vw;border:solid;max-width:30vw;min-width:30vw;border-radius:1vw;margin:15vh auto auto}.content-container[_ngcontent-%COMP%]{margin-left:1.3vw}.content-header[_ngcontent-%COMP%]{color:#fff;font-size:3vh}.new-project-container[_ngcontent-%COMP%]{display:flex;flex-direction:row;margin:3vh 0 0;align-items:baseline}.label[_ngcontent-%COMP%]{margin-right:1vw}.input-style[_ngcontent-%COMP%], .label[_ngcontent-%COMP%]{color:#fff;font-size:2vh}.input-style[_ngcontent-%COMP%]{border-radius:2vw;border:none;outline:none;background-color:#363636;min-width:11vw;max-width:11vw;min-height:4vh;max-height:4vh;padding:0 1vw}.validation[_ngcontent-%COMP%]{color:red}.error-msg[_ngcontent-%COMP%]{font-size:2vh}.select-file-container[_ngcontent-%COMP%]{display:flex;flex-direction:row;margin:2vh 0 0}.file-name-container[_ngcontent-%COMP%]{display:flex;flex-direction:row;margin:1.5vh 0 0 19vh;min-height:4vh}.input[_ngcontent-%COMP%]{color:#7fffd4}.horizontal-line[_ngcontent-%COMP%]{background-color:#fff;min-height:.3vh;max-height:.3vh;margin:2vh auto}.model-button-container[_ngcontent-%COMP%]{display:flex;flex-direction:row-reverse;padding:.5vw}.button-style[_ngcontent-%COMP%]{padding:1vh 1.5vw;border-radius:1vh;border:none;outline:none;color:#fff;cursor:pointer;font-size:2vh}.choose-file-button[_ngcontent-%COMP%]{background-color:#444}.create-btn[_ngcontent-%COMP%]{background-color:#169887}.cancel-btn[_ngcontent-%COMP%]{background-color:#444;margin-right:.7vw}.choose-file-btn[_ngcontent-%COMP%]{font-size:2vh;text-decoration:none;background-color:#444;color:#fff;padding:.5vh 1vw;border:none;border-radius:1vh;margin-right:1vw;cursor:pointer}.label-file[_ngcontent-%COMP%]{padding-top:.5vh}.input-id[_ngcontent-%COMP%]{font-size:2vh;display:none}.filename[_ngcontent-%COMP%]{font-size:2vh;color:#fff;overflow:hidden;text-overflow:ellipsis}.overlay[_ngcontent-%COMP%]{z-index:3000;position:absolute;background-color:rgba(0,0,0,.9);width:99.9vw;height:99.7vh;cursor:not-allowed}"]}),se)}],ue=((le=function e(){a(this,e)}).\u0275mod=w.Fb({type:le}),le.\u0275inj=w.Eb({factory:function(e){return new(e||le)},imports:[[_.d.forChild(de)]]}),le),me=r("KZX/"),pe=((be=function e(){a(this,e)}).\u0275mod=w.Fb({type:be}),be.\u0275inj=w.Eb({factory:function(e){return new(e||be)},imports:[[c.b,me.a,ue]]}),be)}}])}();
!function(t,e){"function"==typeof define&&define.amd?define(["jquery"],function(o){return e(t,o)}):"object"==typeof exports?e(t,require("jquery")):e(t,t.jQuery)}("undefined"!=typeof window?window:this,function(t,e){"use strict";function o(t){t=e.extend({},Z,_,t),C=D();for(var o=e(this),a=0,n=o.length;n>a;a++)i(o.eq(a),t);return S=e(".zoomer-element"),Y(),o}function i(t,o){if(!t.data("zoomer")){o=e.extend({},o,t.data("zoomer-options")),o.$target=t,o.marginReal=2*o.marginMin,o.originalDOM=o.$target.html(),o.$target.find("img").length>0&&(o.source=[],o.$target.find("img").each(function(){o.source.push(e(this).attr("src"))})),o=X(o);var i='<div class="zoomer zoomer-root '+o.customClass+'">';i+='<div class="zoomer-positioner">',i+='<div class="zoomer-holder">',i+="</div>",i+="</div>",i+="</div>",o.$zoomer=e(i),o.$target.addClass("zoomer-element").append(o.$zoomer),o.controls.zoomIn||o.controls.zoomOut||o.controls.zoomLabel||o.controls.next||o.controls.previous?(o.controls.$zoomIn=e(o.controls.zoomIn),o.controls.$zoomOut=e(o.controls.zoomOut),o.controls.$zoomLabel=e(o.controls.zoomLabel),o.controls.$zoomLabelContainer=e(o.controls.zoomLabelContainer),o.controls.$next=e(o.controls.next),o.controls.$previous=e(o.controls.previous)):(i='<div class="zoomer-controls zoomer-controls-'+o.controls.position+'">',i+='<span class="zoomer-previous">&lsaquo;</span>',i+='<span class="zoomer-zoom-out">-</span>',i+='<span class="zoomer-zoom-label">100%</span>',i+='<span class="zoomer-zoom-in">+</span>',i+='<span class="zoomer-next">&rsaquo;</span>',i+="</div>",o.$zoomer.append(i),o.controls.$default=o.$zoomer.find(".zoomer-controls"),o.controls.$zoomIn=o.$zoomer.find(".zoomer-zoom-in"),o.controls.$zoomOut=o.$zoomer.find(".zoomer-zoom-out"),o.controls.$next=o.$zoomer.find(".zoomer-next"),o.controls.$previous=o.$zoomer.find(".zoomer-previous"),o.controls.$zoomLabel=o.$zoomer.find(".zoomer-zoom-label")),o.$positioner=o.$zoomer.find(".zoomer-positioner"),o.$holder=o.$zoomer.find(".zoomer-holder"),o.controls.$zoomIn.on("touchstart.zoomer mousedown.zoomer",o,u).on("touchend.zoomer mouseup.zoomer",o,p),o.controls.$zoomOut.on("touchstart.zoomer mousedown.zoomer",o,u).on("touchend.zoomer mouseup.zoomer",o,p),o.controls.$zoomOut.on("zoomout",o,z),o.controls.$zoomLabelContainer.on("touchstart.zoomer mousedown.zoomer",o,W).on("touchend.zoomer mouseup.zoomer",o,I),o.controls.$next.on("click.zoomer",o,l),o.controls.$previous.on("click.zoomer",o,c),o.$zoomer.on("mousedown.zoomer",o,$).on("touchstart.zoomer MSPointerDown.zoomer",":not(.zoomer-controls)",o,L),o.$target.data("zoomer",o),O.resize.apply(o.$target),o.images.length>0&&a.apply(o.$target,[o])}}function a(t){t.$zoomer.addClass("loading"),t.gallery?t.$zoomer.addClass("zoomer-gallery"):t.$zoomer.removeClass("zoomer-gallery"),"undefined"!=typeof t.$image?t.$holder.animate({opacity:0},300,function(){O.unload.apply(t.$target),n.apply(t.$target,[t,t.images[t.index]])}):n.apply(t.$target,[t,t.images[t.index]])}function n(t,o){if(t.loading=!0,t.tiled){t.tilesTotal=0,t.tilesLoaded=0;var i='<div class="zoomer-tiles">';for(var a in t.images[0])if(t.images[0].hasOwnProperty(a))for(var n in t.images[0][a])t.images[0][a].hasOwnProperty(n)&&(i+='<img class="zoomer-image zoomer-tile" src="'+t.images[0][a][n]+'" data-zoomer-tile="'+a+"-"+n+'" />',t.tilesTotal++);i+="</div>",t.$image=e(i),t.$tiles=t.$image.find("img"),t.$tiles.each(function(o,i){var a=e(i);a.one("load",t,r),a[0].complete&&a.trigger("load")})}else t.$image=e('<img class="zoomer-image" />'),t.$image.one("load.zoomer",t,m).attr("src",o),t.$image[0].complete&&t.$image.trigger("load");t.onContextMenu&&t.$image.contextmenu(t.onContextMenu)}function r(t){var e=t.data;e.tilesLoaded++,e.tilesLoaded===e.tilesTotal&&(e.tiledRows=e.images[0].length,e.tiledColumns=e.images[0][0].length,e.tiledHeight=e.$tiles.eq(0)[0].naturalHeight*e.tiledRows,e.tiledWidth=e.$tiles.eq(0)[0].naturalWidth*e.tiledColumns,m({data:e}))}function m(t){var o=t.data;o.$zoomer.removeClass("loading"),o.tiled?(o.naturalHeight=o.tiledHeight,o.naturalWidth=o.tiledWidth):(o.naturalHeight=o.$image[0].naturalHeight,o.naturalWidth=o.$image[0].naturalWidth),o.retina&&(o.naturalHeight/=2,o.naturalWidth/=2),o.$holder.css({height:o.naturalHeight,width:o.naturalWidth}),o.minHeight=o.naturalHeight,o.minWidth=o.naturalWidth,o.maxHeight=o.naturalHeight*o.overZoom,o.maxWidth=o.naturalWidth*o.overZoom,o.imageRatioWide=o.naturalWidth/o.naturalHeight,o.imageRatioTall=o.naturalHeight/o.naturalWidth,o.startWidth>0?(o.targetImageWidth=o.startWidth,o.targetImageHeight=o.imageRatioTall*o.targetImageWidth):(o.targetImageWidth=o.minWidth,o.targetImageHeight=o.minHeight),(o.naturalHeight>o.frameHeight-o.marginReal||o.naturalWidth>o.frameWidth-o.marginReal)&&(o=h(o));for(var i=0;o.naturalWidth*o.zoomIncrements[i]<o.minWidth;)i++;if(o.zoomIncrements=o.zoomIncrements.slice(i,o.zoomIncrements.length),o.positionerLeft=o.targetPositionerLeft=o.centerLeft,o.positionerTop=o.targetPositionerTop=o.centerTop,o.imageLeft=o.targetImageLeft=Math.round(-o.targetImageWidth/2),o.imageTop=o.targetImageTop=Math.round(-o.targetImageHeight/2),o.imageHeight=o.targetImageHeight,o.imageWidth=o.targetImageWidth,C){var a=o.imageWidth/o.naturalWidth,n=o.imageHeight/o.naturalHeight;o.$positioner.css(w("transform","translate3d("+o.positionerLeft+"px, "+o.positionerTop+"px, 0)")),o.$holder.css(w("transform","translate3d(-50%, -50%, 0) scale("+a+","+n+")"))}else o.$positioner.css({left:o.positionerLeft,top:o.positionerTop}),o.$holder.css({left:o.imageLeft,top:o.imageTop,height:o.imageHeight,width:o.imageWidth});o.$holder.append(o.$image),o.tiled&&(o.$holder.css({background:"url("+o.tiledThumbnail+") no-repeat left top",backgroundSize:"100% 100%"}),o.tileHeightPercentage=100/o.tiledRows,o.tileWidthPercentage=100/o.tiledColumns,o.$tiles.css({height:o.tileHeightPercentage+"%",width:o.tileWidthPercentage+"%"}),o.$tiles.each(function(t,i){var a=e(i),n=a.data("zoomer-tile").split("-");a.css({left:o.tileWidthPercentage*parseInt(n[1],10)+"%",top:o.tileHeightPercentage*parseInt(n[0],10)+"%"})})),o.$holder.css({opacity:1}),o.loading=!1,o.gallery&&g(o)}function g(t){t.index>0&&e('<img src="'+t.images[t.index-1]+'">'),t.index<t.images.length-1&&e('<img src="'+t.images[t.index+1]+'">')}function h(t){return t.naturalHeight>t.naturalWidth?(t.aspect="tall",t.minHeight=Math.round(t.frameHeight-t.marginReal),t.minWidth=Math.round(t.minHeight/t.imageRatioTall),t.minWidth>t.frameWidth-t.marginReal&&(t.minWidth=Math.round(t.frameWidth-t.marginReal),t.minHeight=Math.round(t.minWidth/t.imageRatioWide))):(t.aspect="wide",t.minWidth=Math.round(t.frameWidth-t.marginReal),t.minHeight=Math.round(t.minWidth/t.imageRatioWide),t.minHeight>t.frameHeight-t.marginReal&&(t.minHeight=Math.round(t.frameHeight-t.marginReal),t.minWidth=Math.round(t.minHeight/t.imageRatioTall))),t}function s(){for(var t=0,e=S.length;e>t;t++){var o=S.eq(t).data("zoomer");if("object"==typeof o){o=d(o),o.lastAction=o.action;var i=o.imageWidth/o.naturalWidth,a=o.imageHeight/o.naturalHeight,n=Math.round(100*i)||100,r=n+"%";o.maxZoomLabel&&n===100*o.overZoom&&(r=o.maxZoomLabel),o.controls.$zoomLabel.html(r),C?(o.$positioner.css(w("transform","translate3d("+o.positionerLeft+"px, "+o.positionerTop+"px, 0)")),o.$holder.css(w("transform","translate3d(-50%, -50%, 0) scale("+i+","+a+")"))):(o.$positioner.css({left:o.positionerLeft,top:o.positionerTop}),o.$holder.css({left:o.imageLeft,top:o.imageTop,width:o.imageWidth,height:o.imageHeight})),o.imageWidth-3<=o.minWidth?o.atMinZoom=!0:o.atMinZoom=!1,n===100*o.overZoom?o.atMaxZoom=!0:o.atMaxZoom=!1,o.onZoomCallback&&o.onZoomCallback.apply(o.$zoomer,[o])}}}function d(t,e){if("zoom_in"!==t.action&&"zoom_out"!==t.action&&"zoom_scroll"!==t.action||(t.keyDownTime+=t.increment,void 0===e&&(e=("zoom_out"===t.action?-1:1)*Math.round(t.imageWidth*t.keyDownTime-t.imageWidth)),"tall"===t.aspect?(t.targetImageHeight+=e,t.targetImageWidth=Math.round(t.targetImageHeight/t.imageRatioTall)):(t.targetImageWidth+=e,t.targetImageHeight=Math.round(t.targetImageWidth/t.imageRatioWide))),"zoom_in_incremented"===t.action){for(var o=0;o<t.zoomIncrements.length&&t.zoomIncrements[o]*t.naturalWidth<=t.imageWidth+3;)o++;o===t.zoomIncrements.length?(t.targetImageWidth=t.maxWidth,t.targetImageHeight=t.maxHeight):(t.targetImageWidth=t.zoomIncrements[o]*t.naturalWidth,t.targetImageHeight=t.zoomIncrements[o]*t.naturalHeight)}else if("zoom_out_incremented"===t.action){for(var o=t.zoomIncrements.length-1;o>=0&&t.zoomIncrements[o]*t.naturalWidth>=t.imageWidth-3;)o--;0>o?(t.targetImageWidth=t.minWidth,t.targetImageHeight=t.minHeight):(t.targetImageWidth=t.zoomIncrements[o]*t.naturalWidth,t.targetImageHeight=t.zoomIncrements[o]*t.naturalHeight)}return"tall"===t.aspect?t.targetImageHeight<t.minHeight?(t.targetImageHeight=t.minHeight,t.targetImageWidth=Math.round(t.targetImageHeight/t.imageRatioTall)):t.targetImageHeight>t.maxHeight&&(t.targetImageHeight=t.maxHeight,t.targetImageWidth=Math.round(t.targetImageHeight/t.imageRatioTall)):t.targetImageWidth<t.minWidth?(t.targetImageWidth=t.minWidth,t.targetImageHeight=Math.round(t.targetImageWidth/t.imageRatioWide)):t.targetImageWidth>t.maxWidth&&(t.targetImageWidth=t.maxWidth,t.targetImageHeight=Math.round(t.targetImageWidth/t.imageRatioWide)),t.targetImageLeft=Math.round(.5*-t.targetImageWidth),t.targetImageTop=Math.round(.5*-t.targetImageHeight),"drag"===t.action||"pinch"===t.action?(t.imageWidth=t.targetImageWidth,t.imageHeight=t.targetImageHeight,t.imageLeft=t.targetImageLeft,t.imageTop=t.targetImageTop):(t.imageWidth+=Math.round((t.targetImageWidth-t.imageWidth)*t.enertia),t.imageHeight+=Math.round((t.targetImageHeight-t.imageHeight)*t.enertia),t.imageLeft+=Math.round((t.targetImageLeft-t.imageLeft)*t.enertia),t.imageTop+=Math.round((t.targetImageTop-t.imageTop)*t.enertia)),t.boundsLeft=Math.round(t.frameWidth-.5*t.targetImageWidth-t.marginMax),t.boundsRight=Math.round(.5*t.targetImageWidth+t.marginMax),t.boundsTop=Math.round(t.frameHeight-.5*t.targetImageHeight-t.marginMax),t.boundsBottom=Math.round(.5*t.targetImageHeight+t.marginMax),t.targetPositionerLeft<t.boundsLeft&&(t.targetPositionerLeft=t.boundsLeft),t.targetPositionerLeft>t.boundsRight&&(t.targetPositionerLeft=t.boundsRight),t.targetPositionerTop<t.boundsTop&&(t.targetPositionerTop=t.boundsTop),t.targetPositionerTop>t.boundsBottom&&(t.targetPositionerTop=t.boundsBottom),t.zoomPositionTop>0&&t.zoomPositionLeft>0&&(t.targetPositionerLeft=t.centerLeft-t.targetImageLeft-t.targetImageWidth*t.zoomPositionLeft,t.targetPositionerTop=t.centerTop-t.targetImageTop-t.targetImageHeight*t.zoomPositionTop),"pinch"!==t.action&&(t.targetImageWidth<t.frameWidth&&(t.targetPositionerLeft=t.centerLeft),t.targetImageHeight<t.frameHeight&&(t.targetPositionerTop=t.centerTop)),"drag"===t.action||"pinch"===t.action?(t.positionerLeft=t.targetPositionerLeft,t.positionerTop=t.targetPositionerTop):(t.positionerLeft+=Math.round((t.targetPositionerLeft-t.positionerLeft)*t.enertia),t.positionerTop+=Math.round((t.targetPositionerTop-t.positionerTop)*t.enertia)),t.oldImageWidth=t.imageWidth,t.oldImageHeight=t.imageHeight,t}function l(t){var e=t.data;!e.loading&&e.index+1<e.images.length&&(e.index++,a.apply(e.$target,[e]))}function c(t){var e=t.data;!e.loading&&e.index-1>=0&&(e.index--,a.apply(e.$target,[e]))}function u(t){t.preventDefault(),t.stopPropagation();var o=t.data,i=e(this).hasClass("zoom-in");o=H(o),i?o.action="zoom_in_incremented":o.action="zoom_out_incremented",clearTimeout(o.downTimer),o.downTimer=setTimeout(function(){i?f(t):z(t)},o.maxDownTimer)}function p(t){t.preventDefault&&(t.preventDefault(),t.stopPropagation()),clearTimeout(t.data.downTimer),I(t)}function f(t){t.preventDefault(),t.stopPropagation();var e=t.data;e=H(e),e.keyDownTime=1,e.action="zoom_in"}function z(t){t.preventDefault(),t.stopPropagation();var e=t.data;e=H(e),e.keyDownTime=1,e.action="zoom_out"}function W(t){t.preventDefault(),t.stopPropagation();var e=t.data;e=H(e),e.keyDownTime=1,e.action="zoom_label",e.targetImageWidth=e.naturalWidth,e.targetImageHeight=e.naturalHeight}function I(t){t.preventDefault(),t.stopPropagation();var e=t.data;e=v(e),e.keyDownTime=0,e.action=""}function H(t,e,o){return e=e||.5*t.imageWidth,o=o||.5*t.imageHeight,t.zoomPositionLeft=(e-(t.positionerLeft-t.centerLeft))/t.imageWidth,t.zoomPositionTop=(o-(t.positionerTop-t.centerTop))/t.imageHeight,t}function v(t){return t.zoomPositionTop=0,t.zoomPositionLeft=0,t}function $(t){t.preventDefault&&(t.preventDefault(),t.stopPropagation());var e=t.data;return e.action="drag",e.mouseX=t.pageX,e.mouseY=t.pageY,e.targetPositionerLeft=e.positionerLeft,e.targetPositionerTop=e.positionerTop,"zoomIn"==e.clickModify?(R.on("mouseup.zoomer",e,I),void f(t)):"zoomOut"==e.clickModify?(R.on("mouseup.zoomer",e,I),void z(t)):void R.on("mousemove.zoomer",e,T).on("mouseup.zoomer",e,P)}function T(t){t.preventDefault&&(t.preventDefault(),t.stopPropagation());var e=t.data;t.pageX&&t.pageY&&(e.targetPositionerLeft-=Math.round(e.mouseX-t.pageX),e.targetPositionerTop-=Math.round(e.mouseY-t.pageY),e.mouseX=t.pageX,e.mouseY=t.pageY)}function P(t){t.preventDefault&&(t.preventDefault(),t.stopPropagation());var e=t.data;e.action="",R.off("mousemove.zoomer mouseup.zoomer")}function L(t){if(!(e(t.target).parent(".zoomer-controls").length>0)){t.preventManipulation&&t.preventManipulation(),t.preventDefault(),t.stopPropagation();var o=t.data,i=t.originalEvent;if(i.type.match(/(up|end)$/i))return void y(o,i);if(i.pointerId){var a=!1;for(var n in o.touches)o.touches[n].identifier===i.pointerId&&(a=!0,o.touches[n].pageX=i.clientX,o.touches[n].pageY=i.clientY);a||o.touches.push({identifier:i.pointerId,pageX:i.clientX,pageY:i.clientY})}else o.touches=i.touches;i.type.match(/(down|start)$/i)?M(o):i.type.match(/move$/i)&&x(o)}}function M(t){t.touchEventsBound||(t.touchEventsBound=!0,R.on("touchmove.zoomer MSPointerMove.zoomer",t,L).on("touchend.zoomer MSPointerUp.zoomer",t,L)),t.zoomPercentage=1,t.touches.length>=2&&(t.offset=t.$zoomer.offset(),t.pinchStartX0=t.touches[0].pageX-t.offset.left,t.pinchStartY0=t.touches[0].pageY-t.offset.top,t.pinchStartX1=t.touches[1].pageX-t.offset.left,t.pinchStartY1=t.touches[1].pageY-t.offset.top,t.pinchStartX=(t.pinchStartX0+t.pinchStartX1)/2,t.pinchStartY=(t.pinchStartY0+t.pinchStartY1)/2,t.imageWidthStart=t.imageWidth,t.imageHeightStart=t.imageHeight,H(t),t.pinchDeltaStart=Math.sqrt(Math.pow(t.pinchStartX1-t.pinchStartX0,2)+Math.pow(t.pinchStartY1-t.pinchStartY0,2))),t.mouseX=t.touches[0].pageX,t.mouseY=t.touches[0].pageY}function x(t){1===t.touches.length?(t.action="drag",t.targetPositionerLeft-=t.mouseX-t.touches[0].pageX,t.targetPositionerTop-=t.mouseY-t.touches[0].pageY):t.touches.length>=2&&(t.action="pinch",t.pinchEndX0=t.touches[0].pageX-t.offset.left,t.pinchEndY0=t.touches[0].pageY-t.offset.top,t.pinchEndX1=t.touches[1].pageX-t.offset.left,t.pinchEndY1=t.touches[1].pageY-t.offset.top,t.pinchEndX0===t.lastPinchEndX0&&t.pinchEndY0===t.lastPinchEndY0&&t.pinchEndX1===t.lastPinchEndX1&&t.pinchEndY1===t.lastPinchEndY1||(t.pinchDeltaEnd=Math.sqrt(Math.pow(t.pinchEndX1-t.pinchEndX0,2)+Math.pow(t.pinchEndY1-t.pinchEndY0,2)),t.zoomPercentage=t.pinchDeltaEnd/t.pinchDeltaStart,t.targetImageWidth=Math.round(t.imageWidthStart*t.zoomPercentage),t.targetImageHeight=Math.round(t.imageHeightStart*t.zoomPercentage),t.pinchEndX=(t.pinchEndX0+t.pinchEndX1)/2,t.pinchEndY=(t.pinchEndY0+t.pinchEndY1)/2,t.lastPinchEndX0=t.pinchEndX0,t.lastPinchEndY0=t.pinchEndY0,t.lastPinchEndX1=t.pinchEndX1,t.lastPinchEndY1=t.pinchEndY1)),t.mouseX=t.touches[0].pageX,t.mouseY=t.touches[0].pageY}function y(t,e){if(t.action="",t.lastPinchEndX0=t.pinchEndX0=t.pinchStartX0=0,t.lastPinchEndY0=t.pinchEndY0=t.pinchStartY0=0,t.lastPinchEndX1=t.pinchEndX1=t.pinchStartX1=0,t.lastPinchEndY1=t.pinchEndY1=t.pinchStartY1=0,t.pinchStartX=t.pinchEndX=0,t.pinchStartY=t.pinchEndX=0,v(t),e.pointerId)for(var o in t.touches)t.touches[o].identifier===e.pointerId&&t.touches.splice(o,1);R.off(".zoomer"),t.touchEventsBound=!1}function X(t){return t.tiled=!1,t.gallery=!1,"string"==typeof t.source?t.images=[t.source]:"string"==typeof t.source[0]?(t.images=t.source,t.images.length>1&&(t.gallery=!0)):(t.tiledThumbnail=t.source.thumbnail,t.images=[t.source.tiles],t.tiled=!0),t}function Y(){k||(k=!0,b())}function E(){k=!1}function b(){k&&(t.requestAnimationFrame(b),s())}function w(t,e){var o={};return o["-webkit-"+t]=e,o["-moz-"+t]=e,o["-ms-"+t]=e,o["-o-"+t]=e,o[t]=e,o}function D(){var t="transform",o="translate3d(0px, 0px, 0px)",i=/translate3d\(0px, 0px, 0px\)/g,a=e("<div>");a.css(w(t,o));var n=a[0].style.cssText.match(i);return null!==n&&1===n.length}var S,R=e(t),k=!1,C=!1,Z={onZoomCallback:e.noop,controls:{position:"bottom",zoomIn:null,zoomOut:null,zoomLabel:null,zoomLabelContainer:null,next:null,previous:null},customClass:"",enertia:.2,increment:.01,marginMin:30,marginMax:100,retina:!1,source:null,startWidth:0},_={images:[],aspect:"",action:"",lastAction:"",keyDownTime:0,marginReal:0,originalDOM:"",gallery:!1,index:0,$tiles:null,tiled:!1,tilesTotal:0,tilesLoaded:0,tiledColumns:0,tiledRows:0,tiledHeight:0,tiledWidth:0,tiledThumbnail:null,centerLeft:0,centerTop:0,frameHeight:0,frameWidth:0,naturalHeight:0,naturalWidth:0,imageRatioWide:0,imageRatioTall:0,minHeight:null,minWidth:null,maxHeight:0,maxWidth:0,boundsTop:0,boundsBottom:0,boundsLeft:0,boundsRight:0,imageWidth:0,imageHeight:0,imageLeft:0,imageTop:0,targetImageWidth:0,targetImageHeight:0,targetImageLeft:0,targetImageTop:0,oldImageWidth:0,oldImageHeight:0,positionerLeft:0,positionerTop:0,targetPositionerLeft:0,targetPositionerTop:0,zoomPositionLeft:0,zoomPositionTop:0,offset:null,touches:[],zoomPercentage:1,pinchStartX0:0,pinchStartX1:0,pinchStartY0:0,pinchStartY1:0,pinchEndX0:0,pinchEndX1:0,pinchEndY0:0,pinchEndY1:0,lastPinchEndX0:0,lastPinchEndY0:0,lastPinchEndX1:0,lastPinchEndY1:0,pinchDeltaStart:0,pinchDeltaEnd:0,overZoom:16,clickModify:"move",atMinZoom:!1,atMaxZoom:!0,downTimer:0,maxDownTimer:500,zoomIncrements:[.16,.25,.33,.5,.66,1,2,3,4,5,7,8,12,16]},O={clickModifier:function(t){e(this).each(function(o,i){var a=e(i).data("zoomer");a&&(a.clickModify=t)})},defaults:function(t){return Z=e.extend(Z,t||{}),"object"==typeof this?e(this):!0},destroy:function(){var t=e(this).each(function(t,o){var i=e(o).data("zoomer");i&&(R.off(".zoomer"),i.$holder.off(".zoomer"),i.$zoomer.off(".zoomer"),i.controls.$zoomIn.off(".zoomer"),i.controls.$zoomOut.off(".zoomer"),i.controls.$zoomLabel.off(".zoomer"),i.controls.$next.off(".zoomer"),i.controls.$previous.off(".zoomer"),i.$target.find(".zoomer-root").remove(),i.$target.removeClass("zoomer-element").data("zoomer",null))});return S=e(".zoomer-element"),S.length<1&&E(),t},load:function(t){return this.each(function(o,i){var n=e(i).data("zoomer");n&&(n.source=t,n.index=0,n=X(n),a(n))})},pan:function(t,o){return e(this).each(function(i,a){var n=e(a).data("zoomer");n&&(t/=100,o/=100,n.targetPositionerLeft=Math.round(n.centerLeft-n.targetImageLeft-n.targetImageWidth*t),n.targetPositionerTop=Math.round(n.centerTop-n.targetImageTop-n.targetImageHeight*o))})},resize:function(){return e(this).each(function(t,o){var i=e(o).data("zoomer");i&&(i.frameWidth=i.$target.outerWidth(),i.frameHeight=i.$target.outerHeight(),i.centerLeft=Math.round(.5*i.frameWidth),i.centerTop=Math.round(.5*i.frameHeight),i.minHeight=i.naturalHeight,i.minWidth=i.naturalWidth,(i.naturalHeight>i.frameHeight-i.marginReal||i.naturalWidth>i.frameWidth-i.marginReal)&&(i=h(i)))})},zoomScroll:function(t){return e(this).each(function(o,i){var a=e(i).data("zoomer");a&&(a=H(a),a.keyDownTime=1,a.action="zoom_scroll",d(a,t),a=v(a),a.keyDownTime=0,a.action="")})},zoom100:function(t,o){return e(this).each(function(i,a){var n=e(a).data("zoomer");n&&(n=H(n,t,o),n.keyDownTime=1,n.action="zoom100",n.targetImageWidth=n.naturalWidth,n.targetImageHeight=n.naturalHeight,d(n),n=v(n),n.keyDownTime=0,n.action="")})},unload:function(){return e(this).each(function(){var t=e(this).data("zoomer");t&&"undefined"!=typeof t.$image&&t.$image.remove()})}},q=function(t){return O[t]?O[t].apply(this,Array.prototype.slice.call(arguments,1)):"object"!=typeof t&&t?this:o.apply(this,arguments)};t.zoomer=function(){q.apply(arguments[0],Array.prototype.slice.call(arguments,1))}});
//# sourceMappingURL=jquery.fs.zoomer.min.js-vfl-V8feR.map
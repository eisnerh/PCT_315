define(["require","exports","tslib","external/classnames","external/react","modules/clean/react/sprite","modules/clean/react/starred/actions","modules/clean/react/starred/constants","modules/clean/react/starred/store","modules/clean/react/css"],function(t,e,r,a,s,o,n,i,d,l){"use strict";var c=function(t){function e(e){var r=t.call(this,e)||this;return r.onStoreUpdate=function(){r.setState(r.getStateFromStore())},r.onClick=function(t){t.stopPropagation(),t.preventDefault(),r.state.loadingState!==i.StarredLoadingState.LOADING&&n.StarredActions.update(r.props.role,r.props.id,r.props.idType,!r.state.isStarred)},r.state=r.getStateFromStore(),r.removeStoreListener=d.StarredStore.addListener(r.onStoreUpdate),r}return r.__extends(e,t),e.prototype.componentWillUnmount=function(){this.removeStoreListener&&this.removeStoreListener()},e.prototype.getStateFromStore=function(){var t={id:this.props.id,type:this.props.idType};return{loadingState:d.StarredStore.getLoadingState(t),isStarred:d.StarredStore.getIsStarred(t)}},e.prototype.render=function(){if(void 0===this.state.isStarred)return null;var t=this.state.isStarred?"s_star_32":"s_unstar_32",e={star__toggle:!0,"star__toggle--starred":this.state.isStarred,"star__toggle--unstarred":!this.state.isStarred};return s.createElement("button",{className:a(e),role:"button","aria-pressed":this.state.isStarred,"aria-label":"Star",onClick:this.onClick,onDoubleClick:this.onClick},s.createElement(o,{group:"web",name:t,alt:""}))},e}(s.PureComponent);c.displayName="Star",e.Star=l(c,["/static/css/starred/star-vflQj6Qw_.css"])});
//# sourceMappingURL=star.min.js-vflrdJZI0.map
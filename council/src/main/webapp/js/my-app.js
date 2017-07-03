// Let's register Template7 helper so we can pass json string in links
Template7.registerHelper('json_stringify', function (context) {
    return JSON.stringify(context);
});

// Initialize your app
var myApp = new Framework7({
	modalTitle: '系统',
	cache:true,
	animatePages: false,
	swipeBackPage:false,
    animateNavBackIcon: true,
    // Enable templates auto precompilation
    precompileTemplates: true,
    // Enabled pages rendering using Template7
    template7Pages: true,
    // Specify Template7 data for pages
    template7Data: {	
    	
    	dataCache: {
    		loginInfo:{
        		staff_id:1,
        		account: '12345',
    			last_login_time:'1970-01-01 12:10:00',
        		privilege:{
        			type:true,
        			name:'admin'
        		}
    		},
    		response:{
    			active:false,
    			data:[]
    		}
    		
    	}
    },
	
    onPageInit: function (app, page) {
        if (page.name === 'myreservations') {
        	setTimeout(function(){
            	},1000);
        }
    },
    preroute: function (view, options) {
    	// TODO : 
    }
});

// Export selectors engine
var $$ = Dom7;

// Add main View
var mainView = myApp.addView('.view-main', {
    // Enable dynamic Navbar
    dynamicNavbar: true
});
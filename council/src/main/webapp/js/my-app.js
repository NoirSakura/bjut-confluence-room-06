// Let's register Template7 helper so we can pass json string in links
Template7.registerHelper('json_stringify', function (context) {
    return JSON.stringify(context);
});

// Initialize your app
var myApp = new Framework7({
	modalTitle: '系统',
	animatePages: false,
	swipeBackPage:false,
    animateNavBackIcon: true,
    // Enable templates auto precompilation
    precompileTemplates: true,
    // Enabled pages rendering using Template7
    template7Pages: true,
    // Specify Template7 data for pages
    template7Data: {	
    	// 主页信息
    	index: {
    		loginInfo:{
        		staff_id:0,
        		account: '12345',
    			last_login_time:'1970-01-01 12:10:00',
        		privilege:{
        			type:false,
        			name:'staff'
        		}
    		}
    	},
    	
    	// 我的会议信息
    	myCouncils: {
    		loginInfo:{
        		staff_id:0,
        		account: '12345',
    			last_login_time:'1970-01-01 12:00:00',
        		privilege:{
        			type:false,
        			name:'staff'
        		}
    		}
    	},
    	
    	// 我的预定信息
    	myReservations: {
    		loginInfo:{
        		staff_id:0,
        		account: '12345',
    			last_login_time:'1970-01-01 12:00:00',
        		privilege:{
        			type:false,
        			name:'staff'
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
          //Do something here with home page
        	var myList = myApp.virtualList('.list-block.virtual-list', {
    	    // Array with plain HTML items
    	    items: [
    	    	{
    	    		no:1,
    	    	},
    	    	{
    	    		no:2,
    	    	},
    	    	{
    	    		no:3,
    	    	},
    	    	{
    	    		no:4,
    	    	}
    	    ],
        	template:'<li class="item-content"><div clas="item-inner"><div class="item-title">{{no}}</div></div></li>'
    	});
        	setTimeout(function(){
        	myList = myApp.virtualList('.list-block.virtual-list', {
        	    // Array with plain HTML items
        	    items: [
        	    	{
        	    		no:1,
        	    	},
        	    	{
        	    		no:2,
        	    	},
        	    	{
        	    		no:3,
        	    	},
        	    	{
        	    		no:4,
        	    	},
        	    	{
        	    		no:5,
        	    	}
        	    ],
            	template:'<li class="item-content"><div clas="item-inner"><div class="item-title">{{no}}</div></div></li>'
        	});
        	},1000);
        }
      }
	
	
});

// Export selectors engine
var $$ = Dom7;

// Add main View
var mainView = myApp.addView('.view-main', {
    // Enable dynamic Navbar
	allowDuplicateUrls:true,
    dynamicNavbar: true
});
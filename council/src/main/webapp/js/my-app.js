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
    	}, 
    	
        // Just plain data object that we can pass for other pages using data-contextName attribute
        cars: [
            {
                vendor: 'Volkswagen',
                model: 'Passat',
                power: 152,
                speed: 280,
                weight: 1400,
                color: 'black',
                year: 2012,
                description: ''
            },
            {
                vendor: 'Skoda',
                model: 'Superb',
                power: 152,
                speed: 260,
                weight: 1600,
                color: 'white',
                year: 2013,
                description: ''
            },
            {
                vendor: 'Ford',
                model: 'Mustang',
                power: 480,
                speed: 320,
                weight: 1200,
                color: 'red',
                year: 2014,
                description: ''
            }
        ]
    },

	loginInfo:{
		staff_id:0,
		account: '12345',
		last_login_time:'1970-01-01 12:00:00',
		privilege:{
			type:false,
			name:'staff'
		}
	},
    
});

// Export selectors engine
var $$ = Dom7;

// Add main View
var mainView = myApp.addView('.view-main', {
    // Enable dynamic Navbar
    dynamicNavbar: true
});
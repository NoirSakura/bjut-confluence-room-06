// Let's register Template7 helper so we can pass json string in links
Template7.registerHelper('json_stringify', function (context) {
    return JSON.stringify(context);
});

// Initialize your app
var myApp = new Framework7({
	smartSelectBackOnSelect: true,
	modalTitle: '系统',
	cache:true,
	animatePages: false,
	swipeBackPage:false,
	modalButtonCancel:'取消',
	modalButtonOk:'确定',
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
    	if (page.name === 'index') {
        	$$('a.detail-link').off('click',checkDetail);
        	$$('a.detail-link').on('click',checkDetail);
        }
    	else if (page.name === 'mycouncils') {
        	$$('a.detail-link').off('click',checkDetail);
        	$$('a.detail-link').on('click',checkDetail);
        }
    	else if (page.name === 'myreservations') {
        	$$('a.detail-link').off('click',checkDetail);
        	$$('a.detail-link').on('click',checkDetail);
        }
        else if (page.name === 'departmanage') {
        	$$('a.button-edit-save').off('click',editDepart);
        	$$('a.button-edit-save').on('click',editDepart);
        	$$('a.button-delete').off('click',deleteDepart);
        	$$('a.button-delete').on('click',deleteDepart);
        	$$('a.button-cancel').off('click',cancelDepart);
        	$$('a.button-cancel').on('click',cancelDepart);
        }
        else if (page.name === 'checkrooms') {
        	$$('a.button-detail').off('click',checkRoomInfo);
        	$$('a.button-detail').on('click',checkRoomInfo);
        }
        else if (page.name === 'roominfo') {
        	$$('#mod-save').data('mode','mod');
        	$$('#room-no').show();
        	$$('#room-name').show();
        	$$('#room-state').show();
        	$$('#max-number').show();
        	$$('#room-note').show();
        	$$('#room-no-edit').hide();
        	$$('#room-name-edit').hide();
        	$$('#room-state-edit').hide();
        	$$('#max-number-edit').hide();
        	$$('#room-note-edit').hide();
        	$$('#rangeNumber').hide();
        	$$('a.button-detail').off('click',checkRoomInfo);
        	$$('a.button-detail').on('click',checkRoomInfo);
        }
        else if (page.name === 'regexam') {
        	$$('a.button-pass').off('click',onExamPass);
        	$$('a.button-pass').on('click',onExamPass);
        	$$('a.button-refuse').off('click',onExamRefuse);
        	$$('a.button-refuse').on('click',onExamRefuse);
        }
        else if (page.name === 'reserve') {
        	defaultDateTime();
        }
        else if (page.name === 'councilinfo') {
        	var from = page.fromPage.url;
        	if(from === 'selfcenter/myreservations'){
        		$$('#cancel-reserve').show();
        	}
        	$$('#page-return').on('click',function(){
        		if(from === 'selfcenter/index') {
        			goIndex();
        		}
        		else if(from === 'selfcenter/myreservations') {
        			goMyReservations();
        		}
        		else if(from === 'selfcenter/mycouncils') {
        			goMyCouncils();
        		}
        		else if(from === 'councilreserve/councilsearch') {
        			goCouncilSearch();
        		}
        	});
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
var assert = require('assert');

describe('runicorn page', function() {

    it('should be on correct page with title', function () {
        
        browser.url('http://172.19.0.3:8080')
        var t = browser.getHTML('title')
        //browser.finishLoading()
        var title = browser.getTitle();
        console.log("-------browser", browser, t)
        assert.equal(title, 'Runicorn');
    });

});
var assert = require('assert')
var getos = require('getos')
var ip = '172.26.0.2'


describe('Runicorn UI Tests', function() {
    it('Given I am on the Runicorn page', function () {
        if (getHostOS() !== "darwin") {
            ip = '172.19.0.3'
        }
        browser.url('http://'+ip+':8080')
        var t = browser.getHTML('title')
        var title = browser.getTitle()
        assert.equal(title, 'Runicorn')
    })
})

function getHostOS(){
    return getos(function(e,os) {
        //if(e) return console.log(e)
        //console.log("Your OS is:" +JSON.stringify(os))
        return os.os
      })
}
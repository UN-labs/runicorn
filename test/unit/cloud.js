suite('Runicorn.Cloud', function() {
    
    setup(function(done) {
        the_cloud.push(new Cloud())
        console.log(the_cloud)
        done()
    })

    test('cloud should have x of 600', function() {
        assert.equal(the_cloud[0].x, 600)
    })

    test('cloud should have y of 25', function() {
        assert.equal(the_cloud[0].y, 25)
    })

})

suite('Runicorn.Birds', function() {
    
    setup(function(done) {
        the_birds.push( new Birds() )
        console.log(the_birds)
        done()
    })

    test('speed should be 2.5', function(done) {
        assert.equal(the_birds[0].speed, 2.5)
        done()
    })

    test('x should be 1800', function(done) {
        assert.equal(the_birds[0].x, 1800)
        done()
    })

    test('y should be 70', function(done) {
        assert.equal(the_birds[0].y, 70)
        done()
    })

    test('bird left should be function', function() {
        assert.isFunction(the_birds[0].left)
    })

    test('bird show should be function', function() {
        assert.isFunction(the_birds[0].show)
    })
})

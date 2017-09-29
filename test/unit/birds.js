
suite('runicorn.birds', function() {
    
    setup(function(done) {
        the_birds.push( new Birds() )
        done()
    })

    test('left should be a function', function(done) {
        console.log(the_birds)
        assert.isFunction(the_birds[0].left)
        done()
    })

    test('speed should be 2.5', function(done) {
        console.log(the_birds)
        assert.equal(the_birds[0].speed, 2.5)
        done()
    })
})

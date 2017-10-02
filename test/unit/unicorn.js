suite('Runicorn.Unicorn', function() {
    
    setup(function(done) {
         the_unicorn = new Unicorn()
        done()
    })

    test('unicorn should have x of 25', function() {
        assert.equal(the_unicorn.x, 25)
    })

    test('unicorn should have y of 125', function() {
        assert.equal(the_unicorn.y, 125)
    })
})
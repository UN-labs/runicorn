suite('Runicorn.Unicorn', function() {
    
    press_sound = {setVolume: function(){}, play: function(){}}
    
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

    test('unicorn should have speed of 1.3', function() {
        assert.equal(the_unicorn.speed, 1.3)
    })

    test('unicorn should not be jumping', function() {
        assert.isFalse(the_unicorn.jumped)
    })
    
    test('unicorn should have y of 1.5 when jumping', function() {
        the_unicorn.jump()
        assert.equal(the_unicorn.y, 1.5)
    })

    test('unicorn should change state to jumped=true after jumping', function() {
        the_unicorn.jump()
        assert.isTrue(the_unicorn.jumped)
    })

    test('unicorn should change state to jumped=false after landing', function() {
        the_unicorn.down()
        assert.isFalse(the_unicorn.jumped)
    })
    
})
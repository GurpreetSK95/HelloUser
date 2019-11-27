package com.gurpreetsk.android_starter.greeting

import com.gurpreetsk.android_starter.R
import com.gurpreetsk.android_starter.base.MviActivity
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.Observable
import kotlinx.android.synthetic.main.greeting_activity.*

class GreetingActivity : MviActivity<GreetingState>(), GreetingView {
    override fun getLayoutRes(): Int =
            R.layout.greeting_activity

    override fun bind(states: Observable<GreetingState>): Observable<GreetingState> =
            GreetingModel.bind(lifecycle, inputEditText.textChanges().map { it.toString() })

    override fun effects(state: GreetingState) {
        render(state)
    }

    override fun renderUnknownGreeting() {
        greetingTextView.text = getString(R.string.greeting_stranger)
    }

    override fun greetUser(name: String) {
        greetingTextView.text = getString(R.string.greeting_user, name)
    }
}

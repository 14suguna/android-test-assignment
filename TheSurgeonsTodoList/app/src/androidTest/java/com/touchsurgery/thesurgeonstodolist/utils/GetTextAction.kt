import android.view.View
import android.widget.TextView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import org.hamcrest.Matcher

class GetTextAction(private val callback: (String) -> Unit) : ViewAction {
    override fun getConstraints(): Matcher<View> {
        return isAssignableFrom(TextView::class.java)
    }

    override fun getDescription(): String {
        return "Extract text from TextView"
    }

    override fun perform(uiController: UiController, view: View) {
        val textView = view as TextView
        callback(textView.text.toString())
    }
}

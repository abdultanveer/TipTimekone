import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tiptime.data.User
import com.example.tiptime.data.UserDao
import kotlinx.coroutines.launch

class RoomViewModel(
    private val userDao: UserDao
) : ViewModel() {

    fun insertData() {
        viewModelScope.launch {
            val user = User(name = "User ${System.currentTimeMillis()}")
            userDao.insert(user)
        }
    }

    fun retrieveData() {
        viewModelScope.launch {
            val users = userDao.getAllUsers()

            users.forEach {
                Log.d("DEMO", "User: id=${it.id}, name=${it.name}")
            }

            if (users.isEmpty()) {
                Log.d("DEMO", "No data found")
            }
        }
    }
}
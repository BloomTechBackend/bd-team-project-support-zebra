$(document).ready(function(){
    let modal = $(".modal")
    modal.append(`<div class="modal-container">
    <div class="modal-content">
        <div class="messenger show">
            <div class="search-container">
                <div class="search-content">
                    <input type="text" class="search" placeholder="Search"/>
                </div>
            </div>
            <div class="inbox-container">
                <div class="inbox-content">
                    <div class="grid messages">
                        <div class="message-inbox">
                            <div class="message-inbox-container">
                                <div class="message-inbox-content">
                                    <div class="not-my-profile-picture">
                                        <img class = "inbox-profile-picture" src="../images/profile.png" alt="">
                                    </div>
                                    <div class="not-my-name-last-message">
                                        <div class="not-my-name">
                                            John Doe
                                        </div>
                                        <div class="last-message weight-normal">
                                            Last message..
                                        </div>
                                    </div>
                                    <div class="message-time weight-normal">
                                        7:30AM
                                    </div>
                                    <div class="right-angle-icon">
                                        <img src="" alt="">
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="message-inbox">
                            <div class="message-inbox-container">
                                <div class="message-inbox-content">
                                    <div class="not-my-profile-picture">
                                        <img class = "inbox-profile-picture" src="../images/profile.png" alt="">
                                    </div>
                                    <div class="not-my-name-last-message">
                                        <div class="not-my-name">
                                            John Doe
                                        </div>
                                        <div class="last-message weight-normal">
                                            Last message..
                                        </div>
                                    </div>
                                    <div class="message-time weight-normal">
                                        7:30AM
                                    </div>
                                    <div class="right-angle-icon">
                                        <img src="" alt="">
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
        <div class="btn-messenger" data-open = false> Open </div>
    </div>
    </div>`)
    $(".btn-messenger").click("click", ()=>{

        let btn = $(".btn-messenger")
        let messenger = $(".messenger")
        
        let messengerIsOpen = btn.attr("data-open") == 'true' 
        if(!messengerIsOpen) {
            messenger.removeClass("hide")
            messenger.addClass("show")
            btn.text("Close")
        } else {
            messenger.removeClass("show")
            messenger.addClass("hide")
            btn.text("Open")
        }
        btn.attr("data-open", !messengerIsOpen) 
        
    })
})
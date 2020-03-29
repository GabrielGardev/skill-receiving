export async function applyCommon() {
    /** 
     * Gets data about the user and adds it the context
     */
    this.email = sessionStorage.getItem('email');
    this.loggedIn = !!sessionStorage.getItem('token');
    this.userId = sessionStorage.getItem('userId');

    /**
     * Applies hbs templates
     */
    this.partials = {
        header: await this.load('./templates/common/header.hbs'),
        footer: await this.load('./templates/common/footer.hbs')
    };
}

const Header = () => {
    return (
        <div className="flex justify-between items-center p-4 text-white">
            <div>
                <img src="/Biere.svg" alt="Bière Logo" className="h-12" />
            </div>
            <div>
                <img src="/lateb_logo.png" alt="Lateb Logo" className="h-32" />
            </div>
            <div className="flex flex-col space-y-4 sm:flex-row sm:space-y-0 sm:space-x-4">
                <img src="/Discord.svg" alt="Discord Logo" className="" />
                <img src="/Instagram.svg" alt="Instagram Logo" className="" />
                <img src="/Mail.svg" alt="Mail Logo" className="" />
            </div>
        </div>
    )
}

export default Header;